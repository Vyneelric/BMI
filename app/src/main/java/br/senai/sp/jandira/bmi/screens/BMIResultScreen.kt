package br.senai.sp.jandira.bmi.screens

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.bmi.R
import br.senai.sp.jandira.bmi.calcs.bmiCalulate
import br.senai.sp.jandira.bmi.model.BMIStatus
import br.senai.sp.jandira.bmi.screens.components.BmiLevel
import br.senai.sp.jandira.bmi.utils.numberConvertLocale

@Composable
fun BMIResultScreen(navegacao: NavHostController?) {
    //Abrir ou fechar um arquivo do tipo SharedPreferences
    val context = LocalContext.current
    val userFile = context.getSharedPreferences("user_file", Context.MODE_PRIVATE)
    val userAge = userFile.getInt("user_age" ,0)
    val userWeight = userFile.getFloat("user_weight" ,0.0f)
    val userHeight = userFile.getFloat("user_height" ,0.0f)


    val result = bmiCalulate(
        userWeight.toInt(),
        userHeight.toDouble().div(100)

        )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xff99D06E))
    ) {
        Column {
            Column(
                modifier = Modifier
                    .padding(horizontal = 18.dp, vertical = 30.dp),
            ) {
                Text(
                    text = stringResource(R.string.bmi_result),
                    fontSize = 28.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.ExtraBold
                )
            }
            Card(
                modifier = Modifier
                    .fillMaxSize(),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFFFFFFF)
                ),
                shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()

                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp),
                        horizontalArrangement = Arrangement.SpaceAround

                    ) {
                        Card(
                            modifier = Modifier
                                .size(100.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFFFFFFFF)
                            ),
                            shape = CircleShape,
                            border = BorderStroke(
                                width = 6.dp,
                                color = result.color
                            )
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = numberConvertLocale(result.bmi.second),
                                    fontSize = 32.sp,
                                    color = Color.Black,
                                    fontWeight = FontWeight.ExtraBold
                                )
                            }
                        }
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 15.dp)
                        ,
                        horizontalArrangement = Arrangement.Center
                    ){
                        Text(
                            text = result.bmi.first,
                            fontSize = 22.sp,
                            color = result.color,
                            fontWeight = FontWeight.Medium
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                        ){
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 10.dp)
                                    .height(80.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color(0xFFE7E0EC)
                                )

                            ){
                                Row(
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .fillMaxWidth()
                                    ,
                                    verticalAlignment = Alignment.CenterVertically

                                ){
                                    Column(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .weight(3f),
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Center
                                    ){
                                        Text(
                                            modifier = Modifier
                                                .padding(bottom = 5.dp)
                                            ,
                                            text = stringResource(R.string.age),
                                            fontSize = 20.sp
                                        )
                                        Text(
                                            text = "$userAge",
                                            fontSize = 22.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                    VerticalDivider(
                                        modifier = Modifier
                                            .height(70.dp),
                                        color = Color(0xFFB2ADAD)
                                    )
                                    Column(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .weight(3f),
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Center
                                    ){
                                        Text(
                                            modifier = Modifier
                                                .padding(bottom = 5.dp)
                                            ,
                                            text = stringResource(R.string.weight),
                                            fontSize = 20.sp
                                        )
                                        Text(
                                            text = "$userWeight" + " Kg",
                                            fontSize = 22.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                    VerticalDivider(
                                        modifier = Modifier
                                        .height(70.dp),
                                        color = Color(0xFFB2ADAD)
                                    )
                                    Column(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .weight(3f),
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Center
                                    ){
                                        Text(
                                            modifier = Modifier
                                                .padding(bottom = 5.dp)
                                            ,
                                            text = stringResource(R.string.height),
                                            fontSize = 20.sp
                                        )
                                        Text(
                                            text = "$userHeight",
                                            fontSize = 22.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                }
                            }
                        }
                        Column(
                            modifier = Modifier
                                .height(380.dp)
                                .fillMaxWidth()
                                .padding(start = 20.dp, top = 40.dp, end = 20.dp),
                            verticalArrangement = Arrangement.Center
                        ){
                            BmiLevel(
                                leftText = "Underweight",
                                rightText = "< 18.5",
                                bulletColor = colorResource(R.color.light_blue),
                                background = if (result.status == BMIStatus.UNDER_WEIGHT) colorResource(R.color.light_blue) else Color.Transparent
                            )
                            BmiLevel(
                                leftText = "Normal",
                                rightText = "18.6 - 24.9",
                                bulletColor = colorResource(R.color.light_green),
                                background = if (result.status == BMIStatus.NORMAL) colorResource(R.color.light_green) else Color.Transparent
                            )
                            BmiLevel(
                                leftText = "Overweight",
                                rightText = "25.0 - 29.9",
                                bulletColor = colorResource(R.color.yellow),
                                background = if (result.status == BMIStatus.OVER_WEIGHT) colorResource(R.color.yellow) else Color.Transparent
                            )
                            BmiLevel(
                                leftText = "Obesity Class I",
                                rightText = "30.0 - 34.9",
                                bulletColor = colorResource(R.color.light_orange),
                                background = if (result.status == BMIStatus.OBESITY_1) colorResource(R.color.light_orange) else Color.Transparent
                            )
                            BmiLevel(
                                leftText = "Obesity Class II",
                                rightText = "35.0 - 39.9",
                                bulletColor = colorResource(R.color.dark_orange),
                                background = if (result.status == BMIStatus.OBESITY_2) colorResource(R.color.dark_orange) else Color.Transparent
                            )
                            BmiLevel(
                                leftText = "Obesity Class III",
                                rightText = "> 39.9",
                                bulletColor = colorResource(R.color.light_red),
                                background = if (result.status == BMIStatus.OBESITY_3) colorResource(R.color.light_red) else Color.Transparent
                            )

                        }
                        Column(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ){
                            HorizontalDivider(
                                modifier = Modifier
                                    .width(350.dp)
                                ,
                                color = Color(0xFFB2ADAD)
                            )
                        }
                        Button(
                            onClick = {},
                            modifier = Modifier
                                .height(70.dp)
                                .width(340.dp)
                                .padding(top = 20.dp)
                            ,
                            shape = RoundedCornerShape(size = 15.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF009688)
                            )
                        ) {
                            Text(text = stringResource(R.string.new_calc),
                                fontSize = 26.sp)
                        }
                    }
                }

            }
        }
    }
}

@Preview
@Composable
private fun BMIResultScreenPreview(){
    BMIResultScreen(navegacao = null)
}
