package mx.tecnm.tepic.ladm_u4_p2_canvas

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint

class imagen(lienzo: lienzo,img:Int,posx:Float,posy:Float) {
    var posX=posx
    var posY=posy
    var inc=50f
    var img =BitmapFactory.decodeResource(lienzo.resources,img)

    fun pintarImagen(canvas: Canvas){
        canvas.drawBitmap(img,posX,posY, Paint())
    }

    fun moverImagen(nuevaPos:Float){
        if(nuevaPos<0f){
            posX+=10f
        }else{
            posX-=10f
        }
    }
}