package com.example.jetbizcard

import android.graphics.Paint.Style
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetbizcard.ui.theme.JetBizCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetBizCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CreateBizCard()
                }
            }
        }
    }
}

@Composable
fun CreateBizCard(){



    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {

            Card(modifier = Modifier
                .width(200.dp)
                .height(390.dp)
                .padding(12.dp),
                shape = RoundedCornerShape(corner = CornerSize(15.dp)),
                elevation = 4.dp
            ) {

                Column(modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally) {

                    CreateProfilePicture()

                    Divider(modifier = Modifier.padding(0.dp,5.dp,0.dp,5.dp), thickness = 2.dp)

                    CreateInfo()

                    Button(onClick = {

                    },
                        modifier = Modifier.padding(25.dp)) {
                        
                        Text(text = "Portifólio",
                        style = MaterialTheme.typography.button)
                        
                    }

                    CardContent()



                }
            }

    }

}
/*
@Preview
@Composable
private fun Content(){
    Surface(modifier = Modifier
        .fillMaxWidth()
        .height(90.dp)) {



    }


}
*/


@Preview
@Composable
private fun CardContent(){
        Surface(modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(2.dp, Color.LightGray)
        ) {

            Column(modifier = Modifier
                .fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start) {



                Portifolio(data = listOf(
                    Portifolio(R.drawable.project_1,"Project 1", "A great Project"),
                    Portifolio(R.drawable.project_2,"Project 2", "A great Project"),
                    Portifolio(R.drawable.project_3,"Project 3", "A great Project"),
                    Portifolio(R.drawable.project_1,"Project 1", "A great Project"),
                    Portifolio(R.drawable.project_2,"Project 2", "A great Project"),
                    Portifolio(R.drawable.project_3,"Project 3", "A great Project")))

            }
    }

}

@Composable
fun Portifolio(data: List<Portifolio>) {

    LazyColumn {
        items(data){item ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .padding(10.dp, 5.dp, 10.dp, 2.dp),
                    shape = RoundedCornerShape(5.dp),
                    elevation = 5.dp) {

                Row(modifier = Modifier
                    .fillMaxSize(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(painter = painterResource(id = item.portifolioImage),
                        contentDescription = "Portifolio image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(90.dp))

                    Column(modifier = Modifier.padding(5.dp, 0.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start) {
                        
                        Text(text = item.projectName, style = MaterialTheme.typography.h6)
                        Text(text = item.projectDescription)
                        
                    }

                }

            }


        }
    }
    
}

@Composable
private fun CreateInfo() {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {

        Text(
            text = "Miles P.",
            color = MaterialTheme.colors.primaryVariant,
            style = MaterialTheme.typography.h4
        )

        Text(text = "Android Composer Programmer")

        Text(
            text = "@GiftMendes",
            style = MaterialTheme.typography.subtitle1
        )

    }
}

@Composable
private fun CreateProfilePicture(){

    Surface(modifier = Modifier
        .size(150.dp)
        .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(2.dp, Color.LightGray),
        elevation = 4.dp,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
    ) {
        Image(painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "Profile picture",
            modifier = Modifier.size(135.dp),
            contentScale = ContentScale.Crop)
    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetBizCardTheme {
        CreateBizCard()
    }
}