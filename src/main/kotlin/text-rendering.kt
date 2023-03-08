import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.LineCap
import org.openrndr.draw.loadFont
import org.openrndr.extensions.Screenshots
import org.openrndr.math.IntVector2
import org.openrndr.math.Vector2
import org.openrndr.draw.loadImage
import org.openrndr.shape.Rectangle
import org.openrndr.writer
import kotlin.math.cos
import kotlin.math.sin

fun main() = application {
    configure {
//         -- Settings go here
        width = 770
        height = 578
    }

    program {

//         -- One time set up code goes here
        extend(Screenshots()) {
            contentScale = 4.0
        }

//        -- Simple Text Rendering
//        val font = loadFont("data/fonts/default.otf", 48.0)
//        extend {
//            drawer.clear(ColorRGBa.PINK)
//            drawer.fontMap = font
//            drawer.fill = ColorRGBa.BLACK
//            drawer.text("HELLO WORLD", width / 2.0 - 100.0, height / 2.0)
//        }

//        -- Advanced Text Rendering
//        val font = loadFont("data/fonts/default.otf", 24.0)
//        extend {
//            drawer.clear(ColorRGBa.PINK)
//            drawer.fontMap = font
//            drawer.fill = ColorRGBa.BLACK
//
//            writer {
////              -- A box can be used to define a text area
//                box = Rectangle(50.0, 50.0, 500.0, 300.0)
//                newLine()
//                text("Some cool text or whatever...")
//                newLine()
//                text("In other words, the text is dope AF!")
//            }
//        }

//         -- Text properties
        val font = loadFont("data/fonts/default.otf", 24.0)
        extend {
            drawer.clear(ColorRGBa.PINK)
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
