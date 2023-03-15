import org.openrndr.application
import org.openrndr.color.ColorRGBa

fun main() = application {
    configure {
        width = 800
        height = 600
    }

    program {
        val customDrawStyle = drawer.drawStyle.copy(
            fill = ColorRGBa.PINK,
            stroke = ColorRGBa.BLACK,
            strokeWeight = 4.0
        )

        extend {
            // Draw a circle with the default drawing state
            drawer.circle(200.0, 300.0, 50.0)

            // Apply the custom drawing state
            drawer.drawStyle = customDrawStyle

            // Draw a circle with the custom drawing state
            drawer.circle(400.0, 300.0, 50.0)

            // Revert back to the original drawing state
            drawer.drawStyle = drawer.drawStyle.copy(
                fill = ColorRGBa.WHITE,
                stroke = ColorRGBa.BLACK,
                strokeWeight = 1.0
            )

            // Draw a circle with the original drawing state
            drawer.circle(600.0, 300.0, 50.0)
        }
    }
}