package complex_shapes

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.extensions.Screenshots
import org.openrndr.extra.color.presets.LIGHT_GREEN
import org.openrndr.shape.*
import org.openrndr.math.Vector2



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
            val c = contour {
                // 1. Set a starting point for the cursor
                moveTo(Vector2(width / 2.0 - 150.0, height / 2.0 - 150.0))
                // 2. Draw a line from the cursor to a new point
                lineTo(cursor + Vector2(300.0, 0.0))
                // 3. Draw a line from the cursor to a new point
                lineTo(cursor + Vector2(0.0, 300.0))
                // 4. Draw a line back to the starting point (anchor)
                lineTo(anchor)
                // 5. Close the contour to form a closed shape
                close()

                /*
                ⭐️ By closing the contour, you form a continuous, closed loop
                which can be filled with a color when drawn.
                If you don't close the contour, the shape will remain open,
                and when you draw it with a fill color, the renderer will
                automatically connect the last point to the first point to
                fill the shape, but the outline (stroke) will not show a
                connection between the first and last points.
                 */
            }
            drawer.fill = ColorRGBa.LIGHT_GREEN
            drawer.stroke = null

            // Draw the contour with the specified fill color and no outline
            drawer.contour(c)
        }
    }
}
