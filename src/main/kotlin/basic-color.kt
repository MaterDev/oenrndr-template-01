import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.extensions.Screenshots
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

    oliveProgram {
//         -- One time set up code goes here
        extend(Screenshots()) {
            contentScale = 4.0
        }

        extend {

//      Color Operations
            drawer.stroke = null
            val baseColor = ColorRGBa.LIGHT_SEA_GREEN

//            Draw 16 darker shades of PINK
            for (i in 0..15) {
                drawer.fill = baseColor.shade(i / 15.0)
                drawer.rectangle(35.0 + (700 / 16.0) * i, 32.0, (700 / 16.0), 64.0)
            }

//            Draw 16 lighter shades of PINK
            for (i in 0..15) {
                drawer.fill = baseColor.shade(1.0 + i / 15.0)
                drawer.rectangle(35.0 + (700 / 16.0) * i, 96.0, (700 / 16.0), 64.0)
            }

//            Opacity
            drawer.fill = ColorRGBa.GRAY.shade(0.5)
            drawer.rectangle(35.0, 32.0, 700.0, 64.00)
            for (i in 0..15) {
                drawer.fill = baseColor.opacify(i / 15.0)
                drawer.rectangle(35.0 + (700 / 16.0) * i, 64.0, (700 / 16.0), 64.0)
            }
        }
    }
}
