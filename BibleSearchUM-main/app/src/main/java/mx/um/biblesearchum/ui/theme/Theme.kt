package mx.um.biblesearchum.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = BibleGreen,
    secondary = BibleSage,
    tertiary = BibleGreenDark,
    background = Color(0xFF20251F),
    surface = Color(0xFF2A3029),
    surfaceVariant = Color(0xFF343B33),
    onPrimary = Color.White,
    onBackground = Color(0xFFF2F0E9),
    onSurface = Color(0xFFF2F0E9),
    onSurfaceVariant = Color(0xFFD0D2C9)
)

private val LightColorScheme = lightColorScheme(
    primary = BibleGreen,
    secondary = BibleGreenDark,
    tertiary = BibleMuted,
    background = BibleCream,
    surface = BiblePaper,
    surfaceVariant = BibleSage,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = BibleInk,
    onSurface = BibleInk,
    onSurfaceVariant = BibleMuted
)

@Composable
fun BibleSearchUMTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}