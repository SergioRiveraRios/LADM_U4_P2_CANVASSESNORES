package mx.tecnm.tepic.ladm_u4_p2_canvas

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.media.Image
import android.os.CountDownTimer
import android.view.MotionEvent
import android.view.View
import androidx.core.content.ContextCompat
import java.time.Duration

class lienzo(activity:MainActivity): View(activity) {
    var pokemon= imagen(this, R.drawable.boba,200f,700f);
    var cielo=ContextCompat.getColor(context, R.color.sky)
    var pasto2= ContextCompat.getColor(context,R.color.grass)

    override fun onDraw(canvas: Canvas){
        super.onDraw(canvas)
        val paint= Paint()


        canvas.drawColor(cielo)

        paint.style=Paint.Style.FILL
        paint.color=pasto2

        canvas.drawArc(RectF(-1200f, 1100f, 900f, 3510f), 270f, 90f, true, paint)
        canvas.drawArc(RectF(200f, 1000f, 2110f, 3510f), 180f, 90f, true, paint)

        pokemon.pintarImagen(canvas)

        invalidate()

    }

}