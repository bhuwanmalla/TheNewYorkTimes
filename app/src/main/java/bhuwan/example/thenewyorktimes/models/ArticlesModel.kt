package bhuwan.example.thenewyorktimes.models

data class ArticlesModel(
    val status: String? = null,
    val copyright: String? = null,
    val response: Response? = null
)

data class Response(
    val docs: List<Doc>? = null,
    val meta: Meta? = null
)

data class Doc(
    val abstract: String? = null,
    val web_url: String? = null,
    val snippet: String? = null,
    val lead_paragraph: String? = null,
    val source: Source? = null,
    val multimedia: List<Multimedia>? = null,
    val headline: Headline? = null,
    val keywords: List<Keyword>? = null,
    val pub_date: String? = null,
    val document_type: DocumentType? = null,
    val news_desk: String? = null,
    val section_name: String? = null,
    val byline: Byline? = null,
    val type_of_material: TypeOfMaterial? = null,
    val _id: String? = null,
    val word_count: Long? = null,
    val uri: String? = null,
    val subsectionName: String? = null,
    val printSection: String? = null,
    val printPage: String? = null
)

data class Byline(
    val original: String? = null,
    val person: List<Person>? = null,
    val organization: Any? = null
)

data class Person(
    val firstname: String? = null,
    val middlename: String? = null,
    val lastname: String? = null,
    val qualifier: Any? = null,
    val title: Any? = null,
    val role: Role? = null,
    val organization: String? = null,
    val rank: Long? = null
)

enum class Role {
    Reported
}

enum class DocumentType {
    Article
}

data class Headline(
    val main: String? = null,
    val kicker: String? = null,
    val content_kicker: Any? = null,
    val print_headline: String? = null,
    val name: Any? = null,
    val seo: Any? = null,
    val sub: Any? = null
)

data class Keyword(
    val name: Name? = null,
    val value: String? = null,
    val rank: Long? = null,
    val major: Major? = null
)

enum class Major {
    N
}

enum class Name {
    CreativeWorks,
    Glocations,
    Organizations,
    Persons,
    Subject
}

data class Multimedia(
    val rank: Long? = null,
    val subtype: String? = null,
    val caption: Any? = null,
    val credit: Any? = null,
    val type: Type? = null,
    val url: String? = null,
    val height: Long? = null,
    val width: Long? = null,
    val legacy: Legacy? = null,
    val subType: String? = null,
    val crop_name: String? = null
)

data class Legacy(
    val xlarge: String? = null,
    val xlargewidth: Long? = null,
    val xlargeheight: Long? = null,
    val thumbnail: String? = null,
    val thumbnailwidth: Long? = null,
    val thumbnailheight: Long? = null,
    val widewidth: Long? = null,
    val wideheight: Long? = null,
    val wide: String? = null
)

enum class Type {
    Image
}

enum class Source {
    TheNewYorkTimes
}

enum class TypeOfMaterial {
    Letter,
    News,
    ObituaryObit
}

data class Meta(
    val hits: Long? = null,
    val offset: Long? = null,
    val time: Long? = null
)
