package mx.tecnm.tepic.ladm_u4_p2_canvas

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity(), SensorEventListener {
     lateinit var Lienzo : lienzo
     lateinit var sensorAcelerador: SensorManager
     lateinit var sensorProximidad: SensorManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Lienzo= lienzo(this)
        definirSensores()

        setContentView(Lienzo)
    }

    override fun onSensorChanged(event: SensorEvent) {
       if(event.sensor.type==Sensor.TYPE_ACCELEROMETER){
            Lienzo.pokemon.moverImagen(event.values[0])
       }
        if(event.sensor.type==Sensor.TYPE_PROXIMITY){
            if(event.values[0]==0f){
                Lienzo.cielo=R.color.black
                Lienzo.invalidate()
            }
            if(event.values[0]==5f){
                Lienzo.cielo= R.color.sky
                Lienzo.invalidate()
            }
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

    private fun definirSensores(){
        sensorAcelerador = getSystemService(SENSOR_SERVICE) as SensorManager
        sensorAcelerador.registerListener(this,
            sensorAcelerador.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL)

        sensorProximidad = getSystemService(SENSOR_SERVICE) as SensorManager
        sensorProximidad.getDefaultSensor(Sensor.TYPE_PROXIMITY)?.also { proximity ->
            sensorProximidad.registerListener(this, proximity, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }
}