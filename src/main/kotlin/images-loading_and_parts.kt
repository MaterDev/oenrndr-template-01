import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.LineCap
import org.openrndr.extensions.Screenshots
import org.openrndr.math.IntVector2
import org.openrndr.math.Vector2
import org.openrndr.draw.loadImage
import org.openrndr.shape.Rectangle

fun main() = application {
    configure {
//        Settings go here
    }

    program {

        val image = loadImage("data/images/cheeta.jpg")

//         -- One time set up code goes here
        extend(Screenshots()) {
            contentScale = 4.0
        }

        extend {
//         -- Draw full image without any modifications
            drawer.image(image)

//         -- Render part of image, from source to target
//            val source = Rectangle(0.0, 0.0, 320.0, 240.0)
//            val target = Rectangle(160.0, 120.0, 320.0, 240.0)
//            drawer.image(image, source, target)

//         -- Drawing many parts of images
//            val areas = (0..10).flatMap { y ->
//                (0..10).map { x ->
//                    val source = Rectangle(x * (width / 10.0), y * (height / 10.0), width / 5.0, height / 5.0)
//                    val target = Rectangle(x * (width / 10.0), y * (height / 10.0), width / 10.0, height / 10.0)
//                    source to target
//
//                }
//            }
//            drawer.image(image, areas)
        }


    }
}
