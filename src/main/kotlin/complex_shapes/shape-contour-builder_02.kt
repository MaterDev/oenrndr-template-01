package complex_shapes

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.extensions.Screenshots
import org.openrndr.extra.color.presets.LIGHT_GREEN
import org.openrndr.shape.*
import org.openrndr.math.Vector2
import java.util.Vector


fun main() = application {
    configure {
        width = 770
        height = 578
    }

    program {
//         -- One time set up code goes here
        extend(Screenshots()) {
            contentScale = 4.0
        }

        extend {
           val s = shape {
               contour {
                   moveTo(Vector2(width/2.0 - 150, height/2.0 - 150.0))
                   lineTo(cursor + Vector2(300.0, 0.0))
                   lineTo(cursor + Vector2(0.0, 300.0))
                   lineTo(anchor)
                   close()
               }
               /*
               When contour overlaps a space that has a positive shape,
               it will create a cutout (negative) where it overlaps
               */
               contour {
                   moveTo(Vector2(width/2.0 - 80.0, height/2.0 - 100.0))
                   lineTo(cursor + Vector2(200.0, 0.0))
                   lineTo(cursor + Vector2(0.0, 200.0))
                   lineTo(anchor)
                   close()
               }
               /*
               When contour overlaps a space that has negative (no) shape,
               it will draw a positive shape
               */
               contour {
                   moveTo(Vector2(width/2.0 - 40.0, height/2.0 - 75.0))
                   lineTo(cursor + Vector2(100.0, 0.0))
                   lineTo(cursor + Vector2(0.0, 200.0))
                   lineTo(anchor)
                   close()
               }
           }
            drawer.fill = ColorRGBa.PINK
            drawer.stroke = null
            drawer.shape(s)
        }
    }
}
