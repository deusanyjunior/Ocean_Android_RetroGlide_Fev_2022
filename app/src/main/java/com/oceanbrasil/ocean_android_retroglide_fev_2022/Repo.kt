package com.oceanbrasil.ocean_android_retroglide_fev_2022

/*
 {
        "name": "2TJDF_2019_IA_MaquinaEstado",
        "owner": {
            "login": "paulosalvatore",
            "avatar_url": "https://avatars.githubusercontent.com/u/7906171?v=4",
            "url": "https://api.github.com/users/paulosalvatore",
        },
        "html_url": "https://github.com/paulosalvatore/2TJDF_2019_IA_MaquinaEstado",
    },

 */

data class Repo(
    val name: String,
    val html_url: String,
    val owner: Owner
)

data class Owner(
    val login: String,
    val avatar_url: String,
    val url: String
)
