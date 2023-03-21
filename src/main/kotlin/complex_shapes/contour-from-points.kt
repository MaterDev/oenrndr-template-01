package complex_shapes
import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.extensions.Screenshots
import org.openrndr.extra.color.presets.DARK_SEA_GREEN
import org.openrndr.math.Vector2
import org.openrndr.shape.Segment
import org.openrndr.shape.ShapeContour
import kotlin.math.sin


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

        // Create a list of 30 points with x and y coordinates, generating a wavy pattern
        val points = List(30) {
            Vector2(20.0 + it * 20.0, 300.0 + sin(it * 0.8) * 100.0)
        }
        // Create a closed contour shape from the points list
        val wavyContour = ShapeContour.fromPoints(points, closed = true)

        // Define three segments to create a horizontal contour
        val segments  = listOf(
            Segment(Vector2(10.0, 100.0), Vector2(200.0, 80.0)), // Linear Segment
            Segment(Vector2(200.0, 80.0), Vector2(250.0, 280.0), Vector2(400.0, 80.0)), // Quadratic Bezier Segment
            Segment(Vector2(400.0, 80.0), Vector2(450.0, 180.0), Vector2(500.0, 0.0), Vector2(630.0, 80.0)) // Cubic Bezier Segment
        )

        // Create an open contour shape from the segments list
        val horizontalContour = ShapeContour.fromSegments(segments, closed = false)


        extend {
            drawer.fill = ColorRGBa.PINK
            drawer.contour(wavyContour)

            drawer.strokeWeight = 5.0
            drawer.stroke = ColorRGBa.DARK_SEA_GREEN
            drawer.contour(horizontalContour)
        }
    }
}
