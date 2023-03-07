import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.LineCap
import org.openrndr.extensions.Screenshots
import org.openrndr.math.IntVector2

fun main() = application {
    configure {
//        Settings go here
        width = 640
        height = 480
        windowResizable = true
        position = IntVector2(100, 400)
        title = "OPENRNDR Example"
    }

    program {
//         -- One time set up code goes here
        extend(Screenshots()) {
            contentScale = 4.0
        }

        extend {
//            -- Drawing code goes here
            drawer.clear(ColorRGBa.PINK)

            // -- setup line appearance
            drawer.stroke = ColorRGBa.BLACK
            drawer.strokeWeight = 5.0
            drawer.lineCap = LineCap.ROUND
            // -- draw actual line segment
            // -- parameters define the (x,y) for the segment start and end
            drawer.lineSegment(10.0, height / 2.0 - 20.0, width - 10.0, height / 2.0 - 20.0)

            drawer.lineCap = LineCap.BUTT
            drawer.lineCap = LineCap.BUTT
            drawer.lineSegment(10.0, height / 2.0, width - 10.0, height / 2.0)

            drawer.lineCap = LineCap.SQUARE
            drawer.lineSegment(10.0, height / 2.0 + 20.0, width - 10.0, height / 2.0 + 20.0)

        }


    }
}
