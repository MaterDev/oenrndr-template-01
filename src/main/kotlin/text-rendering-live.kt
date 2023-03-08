import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.loadFont
import org.openrndr.extra.olive.oliveProgram
import org.openrndr.shape.Rectangle
import org.openrndr.writer
import kotlin.math.cos
import kotlin.math.sin

/**
 *  This is a template for a live program.
 *
 *  It uses oliveProgram {} instead of program {}. All code inside the
 *  oliveProgram {} can be changed while the program is running.
 */

fun main() = application {
    configure {
        width = 800
        height = 800
    }
    oliveProgram {
        val font = loadFont("data/fonts/default.otf", 24.0)
        extend {
            drawer.clear(ColorRGBa.fromHex("#3ede39"))
            drawer.fontMap = font
            drawer.fill = ColorRGBa.BLACK

            writer {
//              -- animate the text leading
                leading = cos(seconds) * 20.0 + 20.0
//              -- animate the text tracking
                tracking = sin(seconds) * 20.0 + 24.0

                box = Rectangle(50.0, 50.0, width - 80.0, height - 80.0)
                newLine()
                text("Some cool text or whatever...")
                newLine()
                text("In other words, the text is dope AF!")
                newLine()
                text("I could say less, but you know I love to rant and rave!! 🗣️")
            }
        }
    }
}