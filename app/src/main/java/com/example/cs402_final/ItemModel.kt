package com.example.cs402_final

//This should be expanded to hold all of the data we need to display an item, either on search or on
//the add/edit item screen
data class ItemData(var name: String)

class ItemModel: ArrayList<ItemData>() {

    init {
        //This is placeholder, not sure if we'll need something here like the project with the json
        //loading. Use a normal ArrayList until we decide we need something more
    }
}