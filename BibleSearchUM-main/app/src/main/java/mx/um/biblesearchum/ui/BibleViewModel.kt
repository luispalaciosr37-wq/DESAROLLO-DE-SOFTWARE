package mx.um.biblesearchum.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import mx.um.biblesearchum.model.BibleBook
import mx.um.biblesearchum.network.RetrofitInstance

class BibleViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(BibleUiState())
    val uiState: StateFlow<BibleUiState> = _uiState.asStateFlow()

    init {
        fetchBooks()
    }

    fun fetchBooks() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, errorMessage = null) }
            try {
                val bookList = RetrofitInstance.api.getBooks()
                _uiState.update { it.copy(books = bookList, isLoading = false) }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = "No se pudieron cargar los libros. Revisa tu conexión e inténtalo otra vez."
                    )
                }
            }
        }
    }

    fun onBookSelected(book: BibleBook) {
        _uiState.update {
            it.copy(
                selectedBook = book,
                availableChapters = (1..book.chapters).toList(),
                selectedChapter = null,
                selectedVerse = null,
                availableVerses = emptyList(),
                currentVerseContent = null,
                errorMessage = null
            )
        }
    }

    fun onChapterSelected(chapter: Int) {
        _uiState.update {
            it.copy(
                selectedChapter = chapter,
                availableVerses = (1..150).toList(),
                selectedVerse = null,
                currentVerseContent = null,
                errorMessage = null
            )
        }
    }

    fun onVerseSelected(verse: Int) {
        val currentBook = _uiState.value.selectedBook ?: return
        val currentChapter = _uiState.value.selectedChapter ?: return
        _uiState.update {
            it.copy(selectedVerse = verse, isLoading = true, errorMessage = null)
        }
        viewModelScope.launch {
            try {
                val result = RetrofitInstance.api.getVerse(currentBook.bookId, currentChapter, verse)
                _uiState.update { it.copy(currentVerseContent = result, isLoading = false) }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = "No se pudo obtener ese versículo. Prueba con otra cita."
                    )
                }
            }
        }
    }

    fun clearSelection() {
        _uiState.update { BibleUiState(books = it.books) }
    }
}
