package com.example.project1_letsgov2

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

fun cardViewCallBack1(context: Context, name: String) {
    Toast.makeText(context,"Hello $name",Toast.LENGTH_LONG).show()
}
    @Composable
    fun EventCard(name:String,description:String,location:String,interests:String,image:Int)
    {
        var context= LocalContext.current
        Card(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .wrapContentHeight()
                .clickable { cardViewCallBack1(context, name + description) },
            shape = MaterialTheme.shapes.medium,
            elevation = 5.dp,
            backgroundColor = MaterialTheme.colors.surface
        ) {

            Row (
                verticalAlignment = Alignment.CenterVertically

            ){

                Image(painter = painterResource(id = image),
                    contentDescription =null,
                    modifier= Modifier
                        .size(130.dp)
                        .padding(8.dp),
                    contentScale = ContentScale.Fit
                )
                Column(Modifier.padding(8.dp)) {

                    Text(text = name,
                        style= MaterialTheme.typography.h6,
                        color= MaterialTheme.colors.onSurface,
                        modifier= Modifier.padding(start=30.dp)
                    )
                    Text(text = description,
                        style= MaterialTheme.typography.body1,
                        color= MaterialTheme.colors.onSurface,
                        modifier= Modifier.padding(start=15.dp)
                    )

                    Text(text = location,
                        style= MaterialTheme.typography.body1,
                        color= MaterialTheme.colors.onSurface,
                        modifier= Modifier.padding(start=15.dp)
                    )
                    Text(text = interests,
                        style= MaterialTheme.typography.body1,
                        color= MaterialTheme.colors.onSurface,
                        modifier= Modifier.padding(start=15.dp)
                    )
                }

            }

        }
    }
    @Composable
    fun AllEvents(eventList:List<Event>)
    {

        Scaffold(


        )
        {

            LazyColumn(

                Modifier.fillMaxWidth(),
                contentPadding= PaddingValues(16.dp)

            )
            {

                item {

                    Row(
                        modifier= Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(vertical = 25.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically

                    ) {

                        Text(text = "Local Events",
                            style= MaterialTheme.typography.h5 )
                    }

                }// end of item

                items(eventList)
                { event->

                    EventCard(name = event.name, description = event.description, location = event.location, interests = event.interests, image = event.imageRes)

                }



            }

        }
    }
