package complex_shapes

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.loadFont
import org.openrndr.extra.color.presets.PALE_GREEN
import org.openrndr.shape.*

fun main() = application {
    configure {
        width = 770
        height = 578
    }

    /*
    Boolean operations can be performed on shapes using the `compound {}` builder.
    3 Kinds of compounds:
        - union
        - difference
        - intersection
    */

    program {
        val font = loadFont("data/fonts/default.otf", 24.0)

        extend {
            drawer.fill = ColorRGBa.PALE_GREEN
            drawer.stroke = null
            // - shape union
            val su = compound {
                // union example
                union {
                    shape(Circle(185.0, height / 2.0 - 80.0, 100.0).shape)
                    shape(Circle(185.0, height / 2.0 + 80.0, 100.0).shape)
                }
            }
            drawer.shapes(su)
            // Render text above `union example` that says `union`
            drawer.fill = ColorRGBa.BLACK
            drawer.fontMap = font
            drawer.text("union", 160.0, height / 2.0 - 80.0 - 20.0)

            // - shape difference
            val sd = compound {
                // difference example
                difference {
                    shape(Circle(385.0, height / 2.0 - 80.0, 100.0).shape)
                    shape(Circle(385.0, height / 2.0 + 80.0, 100.0).shape)
                }
            }
            drawer.shapes(sd)
            // Render text above `difference example` that says `difference`
            drawer.fill = ColorRGBa.BLACK
            drawer.fontMap = font
            drawer.text("difference", 360.0, height / 2.0 - 80.0 - 20.0)

        }
    }
}