package com.example.cs402_final.data_classes
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vendors")
data class Vendor (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "rowid") val vendorId : Int,
    @ColumnInfo(name = "vendor_code") val vendorCode : String?,
    @ColumnInfo(name = "vendor_name") val vendorName : String?,
    @ColumnInfo(name = "vendor_phone") val vendorPhone : String?,
    @ColumnInfo(name = "vendor_rep") val vendorRep : String?
)