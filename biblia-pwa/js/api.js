// Cliente de bolls.life (sin API key). Traducción fija: RV1960.
const BASE = "https://bolls.life";
const TRANSLATION = "RV1960";

async function getJSON(url) {
  const res = await fetch(url);
  if (!res.ok) throw new Error(`HTTP ${res.status} al consultar ${url}`);
  return res.json();
}

/** Capítulo completo -> [{ pk, verse, text }, ...] */
export async function getChapter(bookId, chapter) {
  const data = await getJSON(`${BASE}/get-text/${TRANSLATION}/${bookId}/${chapter}/`);
  if (!Array.isArray(data) || data.length === 0) throw new Error("Capítulo vacío o inexistente.");
  return data;
}

/** Un versículo -> { pk, verse, text }  (la API puede devolver objeto o arreglo de 1) */
export async function getVerse(bookId, chapter, verse) {
  const data = await getJSON(`${BASE}/get-verse/${TRANSLATION}/${bookId}/${chapter}/${verse}/`);
  const v = Array.isArray(data) ? data[0] : data;
  if (!v || !v.text) throw new Error("Versículo no encontrado.");
  return v;
}

/** RETO ★★: versículo al azar -> { book, chapter, verse, text }.
 *  El parámetro _ evita que el Service Worker devuelva siempre el mismo versículo guardado. */
export async function getRandomVerse() {
  const data = await getJSON(`${BASE}/get-random-verse/${TRANSLATION}/?_=${Date.now()}`);
  const v = Array.isArray(data) ? data[0] : data;
  if (!v || !v.book || !v.chapter || !v.verse) throw new Error("Respuesta inesperada de la API.");
  return v;
}
