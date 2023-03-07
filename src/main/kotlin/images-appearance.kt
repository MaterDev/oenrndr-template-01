import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.*
import org.openrndr.extensions.Screenshots
import org.openrndr.math.IntVector2
import org.openrndr.math.Vector2
import org.openrndr.extra.color.presets.BISQUE
import org.openrndr.extra.color.presets.ORANGE_RED
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
//            🎇 A linear color transform can be applied to images
        //            by setting Drawer.drawStyle.colorMatrix to a Matrix55 value.

//            -- Tint image
//            drawer.drawStyle.colorMatrix = tint(ColorRGBa.ORANGE_RED)
//            drawer.image(image, 0.0, 0.0)

//            -- Invert colors
//            drawer.drawStyle.colorMatrix = invert
//            drawer.image(image, 0.0, 0.0)

//            -- Grayscale image
//            drawer.drawStyle.colorMatrix = grayscale(1.0/3.0, 1.0/3.0, 1.0/3.0)
//            drawer.image(image)

//            -- Concatenating color transforms
        //            combining transforms, using the multiplication operator
        //            ‼️ read from right -> left
            drawer.drawStyle.colorMatrix = tint(ColorRGBa.PINK) * grayscale()
            drawer.image(image)
        }

    }
}
