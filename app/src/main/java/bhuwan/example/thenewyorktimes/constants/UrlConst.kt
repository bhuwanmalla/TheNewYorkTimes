package bhuwan.example.thenewyorktimes.constants

object UrlConst {

    private const val API_KEY = "AVKbjzmjdCDN1jxc3FCvZNFebyZWDUgc"
    const val BASE_URL = "https://api.nytimes.com/svc/"
    const val ARTICLES_URL = "${BASE_URL}search/v2/articlesearch.json?api-key=${API_KEY}"
    const val TOP_STORIES_URL = "${BASE_URL}topstories/v2/world.json?api-key=${API_KEY}"


}