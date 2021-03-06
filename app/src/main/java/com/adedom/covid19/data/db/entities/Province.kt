package com.adedom.covid19.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "province")
data class Province(
    @PrimaryKey(autoGenerate = false) @ColumnInfo(name = "province_id") var provinceId: Int = 0,
    @SerializedName("Amnat Charoen") @ColumnInfo(name = "amnat_charoen") val amnatCharoen: Int? = null,
    @SerializedName("Bangkok") @ColumnInfo(name = "bangkok") val bangkok: Int? = null,
    @SerializedName("Buriram") @ColumnInfo(name = "buriram") val buriram: Int? = null,
    @SerializedName("Chachoengsao") @ColumnInfo(name = "chachoengsao") val chachoengsao: Int? = null,
    @SerializedName("Chaiyaphum") @ColumnInfo(name = "chaiyaphum") val chaiyaphum: Int? = null,
    @SerializedName("Chanthaburi") @ColumnInfo(name = "chanthaburi") val chanthaburi: Int? = null,
    @SerializedName("Chiang Mai") @ColumnInfo(name = "chiang_mai") val chiangMai: Int? = null,
    @SerializedName("Chiang Rai") @ColumnInfo(name = "chiang_rai") val chiangRai: Int? = null,
    @SerializedName("Chonburi") @ColumnInfo(name = "chonburi") val chonburi: Int? = null,
    @SerializedName("Chumphon") @ColumnInfo(name = "chumphon") val chumphon: Int? = null,
    @SerializedName("Kalasin") @ColumnInfo(name = "kalasin") val kalasin: Int? = null,
    @SerializedName("Kanchanaburi") @ColumnInfo(name = "kanchanaburi") val kanchanaburi: Int? = null,
    @SerializedName("Khon Kaen") @ColumnInfo(name = "khon_kaen") val khonKaen: Int? = null,
    @SerializedName("Krabi") @ColumnInfo(name = "krabi") val krabi: Int? = null,
    @SerializedName("Lampang") @ColumnInfo(name = "lampang") val lampang: Int? = null,
    @SerializedName("Lamphun") @ColumnInfo(name = "lamphun") val lamphun: Int? = null,
    @SerializedName("Loei") @ColumnInfo(name = "loei") val loei: Int? = null,
    @SerializedName("Lopburi") @ColumnInfo(name = "lopburi") val lopburi: Int? = null,
    @SerializedName("Mae Hong Son") @ColumnInfo(name = "mae_hong_son") val maeHongSon: Int? = null,
    @SerializedName("Maha Sarakham") @ColumnInfo(name = "maha_sarakham") val mahaSarakham: Int? = null,
    @SerializedName("Mukdahan") @ColumnInfo(name = "mukdahan") val mukdahan: Int? = null,
    @SerializedName("Nakhon Nayok") @ColumnInfo(name = "nakhon_nayok") val nakhonNayok: Int? = null,
    @SerializedName("Nakhon Pathom") @ColumnInfo(name = "nakhon_pathom") val nakhonPathom: Int? = null,
    @SerializedName("Nakhon Phanom") @ColumnInfo(name = "nakhon_phanom") val nakhonPhanom: Int? = null,
    @SerializedName("Nakhon Ratchasima") @ColumnInfo(name = "nakhon_ratchasima") val nakhonRatchasima: Int? = null,
    @SerializedName("Nakhon Sawan") @ColumnInfo(name = "nakhon_sawan") val nakhonSawan: Int? = null,
    @SerializedName("Nakhon Si Thammarat") @ColumnInfo(name = "nakhon_si_thammarat") val nakhonSiThammarat: Int? = null,
    @SerializedName("Narathiwat") @ColumnInfo(name = "narathiwat") val narathiwat: Int? = null,
    @SerializedName("Nong Bua Lamphu") @ColumnInfo(name = "nong_bua_lamphu") val nongBuaLamphu: Int? = null,
    @SerializedName("Nong Khai") @ColumnInfo(name = "nong_khai") val nongKhai: Int? = null,
    @SerializedName("Nonthaburi") @ColumnInfo(name = "nonthaburi") val nonthaburi: Int? = null,
    @SerializedName("Pathum Thani") @ColumnInfo(name = "pathum_thani") val pathumThani: Int? = null,
    @SerializedName("Pattani") @ColumnInfo(name = "pattani") val pattani: Int? = null,
    @SerializedName("Phatthalung") @ColumnInfo(name = "phatthalung") val phatthalung: Int? = null,
    @SerializedName("Phayao") @ColumnInfo(name = "phayao") val phayao: Int? = null,
    @SerializedName("Phetchabun") @ColumnInfo(name = "phetchabun") val phetchabun: Int? = null,
    @SerializedName("Phetchaburi") @ColumnInfo(name = "phetchaburi") val phetchaburi: Int? = null,
    @SerializedName("Phitsanulok") @ColumnInfo(name = "phitsanulok") val phitsanulok: Int? = null,
    @SerializedName("Phra Nakhon Si Ayutthaya") @ColumnInfo(name = "phra_nakhon_si_ayutthaya") val phraNakhonSiAyutthaya: Int? = null,
    @SerializedName("Phrae") @ColumnInfo(name = "phrae") val phrae: Int? = null,
    @SerializedName("Phuket") @ColumnInfo(name = "phuket") val phuket: Int? = null,
    @SerializedName("Prachinburi") @ColumnInfo(name = "prachinburi") val prachinburi: Int? = null,
    @SerializedName("Prachuap Khiri Khan") @ColumnInfo(name = "prachuap_khiri_khan") val prachuapKhiriKhan: Int? = null,
    @SerializedName("Ratchaburi") @ColumnInfo(name = "ratchaburi") val ratchaburi: Int? = null,
    @SerializedName("Rayong") @ColumnInfo(name = "rayong") val rayong: Int? = null,
    @SerializedName("Roi Et") @ColumnInfo(name = "roi_et") val roiEt: Int? = null,
    @SerializedName("Sa Kaeo") @ColumnInfo(name = "sa_kaeo") val saKaeo: Int? = null,
    @SerializedName("Sakon Nakhon") @ColumnInfo(name = "sakon_nakhon") val sakonNakhon: Int? = null,
    @SerializedName("Samut Prakan") @ColumnInfo(name = "samut_prakan") val samutPrakan: Int? = null,
    @SerializedName("Samut Sakhon") @ColumnInfo(name = "samut_sakhon") val samutSakhon: Int? = null,
    @SerializedName("Samut Songkhram") @ColumnInfo(name = "samut_songkhram") val samutSongkhram: Int? = null,
    @SerializedName("Saraburi") @ColumnInfo(name = "saraburi") val saraburi: Int? = null,
    @SerializedName("Sisaket") @ColumnInfo(name = "sisaket") val sisaket: Int? = null,
    @SerializedName("Songkhla") @ColumnInfo(name = "songkhla") val songkhla: Int? = null,
    @SerializedName("Sukhothai") @ColumnInfo(name = "sukhothai") val sukhothai: Int? = null,
    @SerializedName("Suphan Buri") @ColumnInfo(name = "suphan_buri") val suphanBuri: Int? = null,
    @SerializedName("Surat Thani") @ColumnInfo(name = "surat_thani") val suratThani: Int? = null,
    @SerializedName("Surin") @ColumnInfo(name = "surin") val surin: Int? = null,
    @SerializedName("Tak") @ColumnInfo(name = "tak") val tak: Int? = null,
    @SerializedName("Trang") @ColumnInfo(name = "trang") val trang: Int? = null,
    @SerializedName("Ubon Ratchathani") @ColumnInfo(name = "ubon_ratchathani") val ubonRatchathani: Int? = null,
    @SerializedName("Udon Thani") @ColumnInfo(name = "udon_thani") val udonThani: Int? = null,
    @SerializedName("Unknown") @ColumnInfo(name = "unknown") val unknown: Int? = null,
    @SerializedName("Uthai Thani") @ColumnInfo(name = "uthai_thani") val uthaiThani: Int? = null,
    @SerializedName("Uttaradit") @ColumnInfo(name = "uttaradit") val uttaradit: Int? = null,
    @SerializedName("Yala") @ColumnInfo(name = "yala") val yala: Int? = null,
    @SerializedName("Yasothon") @ColumnInfo(name = "yasothon") val yasothon: Int? = null
)
