package com.example.conversordemedidas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*
import java.util.*
import java.lang.Double

class conversorTemp : AppCompatActivity() {

    var unidades = arrayOf("Celsius (°C)", "Kelvin (K)", "Fahrenheit(°F)")
    var selecao = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversor_temp)

        //Pega o conteúdo do array e exibe na listagem, levando o valor à variável
        val spinner = findViewById<Spinner>(R.id.seelct)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)
        val txtValor = findViewById<EditText>(R.id.txtValor)
        val btnCalcular = findViewById<Button>(R.id.btnConverter)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, unidades)
        spinner.adapter = adapter

        //Seleciona um item
        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{

            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selecao = position
            }
        }

        btnCalcular.setOnClickListener {
            val valor = txtValor.text.toString()
            if(valor != ""){
                if(selecao == 0){
                    var texto = " Kelvin = "
                    texto +=  formataValor(Double.parseDouble(valor) + 273.15)
                    texto += "K \n Fahrenheit = "
                    texto += formataValor((Double.parseDouble(valor) * 9/5)+ 32f)
                    texto += "°F"
                    txtResultado.text = texto

                }else if(selecao == 1){
                    var texto = " Celsius = "
                    texto +=  formataValor(Double.parseDouble(valor) - 273.15)
                    texto += "°C \n Fahrenheit = "
                    texto += formataValor((Double.parseDouble(valor) - 273.15)* 9/5 + 32f)
                    texto += "°F \n"

                    txtResultado.text = texto

                }else if(selecao == 2){
                    var texto = " Celsius = "
                    texto +=  formataValor((Double.parseDouble(valor) - 32) * 5/9 )
                    texto += "°C \n Kelvin = "
                    texto += formataValor((Double.parseDouble(valor) - 32) * 5/9 + 273.15)
                    texto += "K"

                    txtResultado.text = texto

                }
            }else{
                txtResultado.text = "Adicione um valor para ser Convertido!"
            }
        }

        //Ativando o botão de voltar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun formataValor(valor: kotlin.Double): Any? {
        return String.format(Locale.FRANCE,"%.2f",valor)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}