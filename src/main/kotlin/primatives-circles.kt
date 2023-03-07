import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.extensions.Screenshots
import org.openrndr.math.IntVector2

fun main() = application {
    configure {
//        Settings go here
        width = 640
        height = 480
        windowResizable = true
        position = IntVector2(100,400)
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

            // -- draw circle with white fill and black stroke
            drawer.fill = ColorRGBa.WHITE
            drawer.stroke = ColorRGBa.BLACK
            drawer.strokeWeight = 1.0
            drawer.circle(width / 6.0, height / 2.0, width / 8.0)

            // -- draw circle without fill, but with black stroke
            drawer.fill = null
            drawer.stroke = ColorRGBa.BLACK
            drawer.strokeWeight = 1.0
            drawer.circle(width/6.0 + width/3.0, height/2.0, width/9.0)

            // -- draw circle with white fill, but without stroke
            drawer.fill = ColorRGBa.WHITE
            drawer.stroke = null
            drawer.strokeWeight = 1.0
            drawer.circle(width/6.0 + 2 * width/3.0, height/2.0, width/8.0)
        }


    }
}
