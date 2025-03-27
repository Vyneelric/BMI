package br.senai.sp.jandira.bmi.screens

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.bmi.R

@Composable
fun UserDataScreen(navegacao: NavHostController?) {

    var ageInt = remember {
        mutableStateOf("")
    }

    var weightFloat = remember {
        mutableStateOf("")
    }

    var heightFloat = remember {
        mutableStateOf("")
    }


    //Abrir ou fechar um arquivo do tipo SharedPreferences
    val context = LocalContext.current
    val userFile = context.getSharedPreferences("user_file", Context.MODE_PRIVATE)
    val userName = userFile.getString("user_name" ,"")


    val editor = userFile.edit()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(color = 0xff99C375)
            )
    ) {
        Column{
            Column(
                modifier = Modifier
                    .padding(horizontal = 18.dp, vertical = 30.dp),
            ){
                Text(
                    text = stringResource(R.string.hi) + ", $userName !",
                    fontSize = 28.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.ExtraBold
                )
            }
            Card(
                modifier = Modifier
                    .fillMaxSize(),
                shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
            ){
                Column(
                    modifier = Modifier
                        .fillMaxSize()

                ){
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 90.dp),
                        horizontalArrangement = Arrangement.SpaceAround

                    ){
                        Card(
                            modifier = Modifier
                                .size(100.dp),
                            shape = CircleShape,
                            border = BorderStroke(
                                width = 2.dp,
                                color = Color(0xFFEE1FF8)
                            )
                        ){
                            Image(
                                modifier = Modifier
                                    .fillMaxSize(),
                                painter = painterResource(R.drawable.man),
                                contentDescription = ""
                            )
                        }
                        Card(
                            modifier = Modifier
                                .size(100.dp),
                            shape = CircleShape,
                            border = BorderStroke(
                                width = 2.dp,
                                color = Color(0xFFEE1FF8)
                            )
                        ){
                            Image(
                                modifier = Modifier
                                    .fillMaxSize(),
                                painter = painterResource(R.drawable.woman),
                                contentDescription = ""
                            )
                        }
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp)
                        ,
                        horizontalArrangement = Arrangement.SpaceAround
                    ){
                        Button(
                            onClick = {},
                            modifier = Modifier
                                .height(45.dp)
                                .width(150.dp)
                            ,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Blue
                            )
                        ) {
                            Text(text = stringResource(R.string.genderM),
                                fontSize = 22.sp
                                )
                        }
                        Button(
                            onClick = {},
                            modifier = Modifier
                                .height(45.dp)
                                .width(150.dp)
                            ,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xff469488)
                            )
                        ) {
                            Text(text = stringResource(R.string.genderW),
                                fontSize = 22.sp)
                        }
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 30.dp)
                        ,
                        horizontalAlignment = Alignment.CenterHorizontally

                    ){
                        OutlinedTextField(
                            modifier = Modifier
                                .padding(bottom = 30.dp)
                                .width(340.dp)
                            ,
                            shape = RoundedCornerShape(size = 15.dp),
                            value = ageInt.value,
                            onValueChange = {
                                ageInt.value = it
                            },
                            label = {
                                Text(
                                    stringResource(
                                        R.string.age
                                    ),
                                    fontSize = 20.sp
                                )
                            },
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.hastag),
                                    contentDescription = "",
                                    tint = Color.Gray
                                )
                            }
                        )
                        OutlinedTextField(
                            modifier = Modifier
                                .padding(bottom = 30.dp)
                                .width(340.dp)
                            ,
                            shape = RoundedCornerShape(size = 15.dp),
                            value = weightFloat.value,
                            onValueChange = {
                                weightFloat.value = it
                            },
                            label = {
                                Text(
                                    stringResource(
                                        R.string.weight,
                                    ),
                                    fontSize = 20.sp
                                )
                            },
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.balance),
                                    contentDescription = "",
                                    tint = Color.Gray
                                )
                            }
                        )
                        OutlinedTextField(
                            modifier = Modifier
                                .padding(bottom = 120.dp)
                                .width(340.dp)
                            ,
                            shape = RoundedCornerShape(size = 15.dp),
                            value = heightFloat.value,
                            onValueChange = {
                                heightFloat.value = it
                            },
                            label = {
                                Text(
                                    stringResource(
                                        R.string.height
                                    ),
                                    fontSize = 20.sp
                                )
                            },
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.arrow),
                                    contentDescription = "",
                                    tint = Color.Gray
                                )
                            }
                        )
                        Button(
                            onClick = {
                                val age = ageInt.value
                                val weight = weightFloat.value.toFloat()
                                val height = heightFloat.value.toFloat()

                                editor.putString("user_age", age)
                                editor.putFloat("user_weight", weight)
                                editor.putFloat("user_height", height)

                                editor.apply()

                                navegacao?.navigate(route = "bmi_result")
                            },
                            modifier = Modifier
                                .height(70.dp)
                                .width(340.dp)
                                .padding(top = 10.dp)
                            ,
                            shape = RoundedCornerShape(size = 15.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF469488)
                            )
                        ) {
                            Text(text = stringResource(R.string.calculate),
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
private fun UserDataScreenPreview() {
    UserDataScreen(null)
}
