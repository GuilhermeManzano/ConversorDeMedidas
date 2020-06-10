package com.example.conversordemedidas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*
import kotlin.Double as Double1

class ConversorComprimento : AppCompatActivity() {

    var medidas = arrayOf("Milímitro (mm)", "Centímetro (cm)", "Metro (m)", "Quilômetro (km)")
    var selecao = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversor_comprimento)

        val spinner = findViewById<Spinner>(R.id.seelct)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)
        val txtValor = findViewById<EditText>(R.id.txtValor)
        val btnCalcular = findViewById<Button>(R.id.btnConverter)

        //Pega o conteúdo do array e exibe na listagem, levando o valor à variável
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, medidas)
        spinner.adapter = adapter

        //Pega a posição da opção selecionado do array
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selecao = position
            }
        }
        //Calculando o valor das medidas
        btnCalcular.setOnClickListener {
            val valor = txtValor.text.toString()
            if(valor != "") {
                if(selecao == 0) {
                    var texto = "Centímetro = "
                    texto += Double.parseDouble(valor) / 10f
                    texto += "cm \nMetro = "
                    texto += Double.parseDouble(valor) / 1000f
                    texto += "m \nQuilômetro = "
                    texto += Double.parseDouble(valor) / 1000000f
                    texto += "km"

                    txtResultado.text = texto
                } else if(selecao == 1) {
                    var texto = "Milímetro = "
                    texto += Double.parseDouble(valor) * 10f
                    texto += "mm \nMetro = "
                    texto += Double.parseDouble(valor) / 100f
                    texto += "m \nQuilômetro = "
                    texto += Double.parseDouble(valor) / 100000f
                    texto += "km"

                    txtResultado.text = texto
                } else if(selecao == 2) {
                    var texto = "Milímetro = "
                    texto += Double.parseDouble(valor) * 1000f
                    texto += "mm \nCentímetro = "
                    texto += Double.parseDouble(valor) * 100f
                    texto += "cm \nQuilômetro = "
                    texto += Double.parseDouble(valor) / 100f
                    texto += "km"

                    txtResultado.text = texto
                } else if(selecao == 3){
                    var texto = "Milímetro = "
                    texto += Double.parseDouble(valor) * 1000000f
                    texto += "mm \nCentímetro = "
                    texto += Double.parseDouble(valor) * 100000f
                    texto += "cm \nMetro = "
                    texto += Double.parseDouble(valor) * 1000f
                    texto += "m"

                    txtResultado.text = texto
                }
            } else {
                txtResultado.text = "Adicione um valor para ser convertido."
            }
        }

        //Ativando o botão de voltar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}