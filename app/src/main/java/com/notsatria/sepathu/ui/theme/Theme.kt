package com.notsatria.sepathu.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = DarkNavy,
    secondary = Purple,
    tertiary = Cyan,
    background = DarkNavy
)

/* Other default colors to override
private val LightColorScheme = lightColorScheme(
primary = Purple40,
secondary = PurpleGrey40,
tertiary = Pink40

background = Color(0xFFFFFBFE),
surface = Color(0xFFFFFBFE),
onPrimary = Color.White,
onSecondary = Color.White,
onTertiary = Color.White,
onBackground = Color(0xFF1C1B1F),
onSurface = Color(0xFF1C1B1F),
)
*/

@Composable
fun SepathuTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = DarkColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}