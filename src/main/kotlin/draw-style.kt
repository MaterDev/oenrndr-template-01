import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.extensions.Screenshots
import org.openrndr.extra.color.presets.GREEN_YELLOW
import org.openrndr.extra.color.presets.LIGHT_SEA_GREEN
import org.openrndr.extra.olive.oliveProgram

fun main() = application {
    configure {
//        Settings go here
        width = 770
        height = 200

    }

//      OPENRNDR primarily uses red-green-blue(-alpha) color stored in ColorRGBa instances.
//      ColorRGBa’s channels store values in the range [0, 1].

    program {
//         -- One time set up code goes here
        extend(Screenshots()) {
            contentScale = 4.0
        }

        // If you wanted to take the current drawStyle and preserver it in a variable:
        val active = drawer.drawStyle.copy()

        extend {
            drawer.pushStyle()

            // Box # 1 - RED
            drawer.fill = ColorRGBa.RED
            drawer.strokeWeight = 3.0
            drawer.rectangle(10.0, 10.0, 100.0, 100.0)

            drawer.pushStyle()

            // Box # 2 - BLUE
            drawer.fill = ColorRGBa.BLUE
            drawer.stroke = ColorRGBa.GREEN
            drawer.translate(150.0, 0.0)
            drawer.rectangle(10.0, 10.0, 100.0, 100.0)

            drawer.popStyle() // This will discard the BLUE fill and translation

            /* Box # 3 - RED
                    This rectangle will be drawn with the RED fill because
                    the previous state was restored
            */
            drawer.rectangle(175.0, 10.0, 100.0, 100.0)


            // This will revert to the original drawing state before any changes were made
            drawer.popStyle()

            drawer.rectangle(325.0, 10.0, 100.0, 100.0)
        }
    }
}
