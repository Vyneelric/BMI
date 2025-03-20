package br.senai.sp.jandira.bmi.screens

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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.bmi.R

@Composable
fun BMIResultScreen() {
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
                                color = Color(0xFFF19700)
                            )
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = stringResource(R.string.number_bmi),
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
                            text = stringResource(R.string.bmi_class),
                            fontSize = 22.sp,
                            color = Color.Black,
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
                                            text = stringResource(R.string.ex_age),
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
                                            text = stringResource(R.string.ex_weight),
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
                                            text = stringResource(R.string.ex_high),
                                            fontSize = 22.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                }
                            }
                        }
                        Column(
                            modifier = Modifier
                                .height(340.dp)
                        ){

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
                                .height(90.dp)
                                .width(340.dp)
                                .padding(top = 40.dp)
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
    BMIResultScreen()
}
