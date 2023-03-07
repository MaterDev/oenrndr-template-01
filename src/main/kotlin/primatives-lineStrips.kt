import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.LineCap
import org.openrndr.extensions.Screenshots
import org.openrndr.math.IntVector2
import org.openrndr.math.Vector2

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

//        Circles
        extend {
//            -- Drawing code goes here
            drawer.clear(ColorRGBa.PINK)

            // -- setup line appearance
            drawer.stroke = ColorRGBa.BLACK
            drawer.strokeWeight = 5.0
            drawer.lineCap = LineCap.ROUND

            val points = listOf(
                Vector2(10.0, height -10.0),
                Vector2(width/2.0, 10.0),
                Vector2(width - 10.0, height - 10.0)
            )

            drawer.lineStrip(points)
        }


    }
}
