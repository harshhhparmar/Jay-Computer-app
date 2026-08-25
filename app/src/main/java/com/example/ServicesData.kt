package com.example

data class Service(
    val id: String,
    val titleEn: String,
    val titleGu: String,
    val categoryEn: String,
    val categoryGu: String,
    val descriptionEn: String,
    val descriptionGu: String,
    val documentsEn: List<String>,
    val documentsGu: List<String>,
    val iconName: String,
    val popular: Boolean
)

object ServicesData {
    val services = listOf(
        Service(
            id = "pan-card",
            titleEn = "PAN Card Services",
            titleGu = "પાન કાર્ડ",
            categoryEn = "Cards",
            categoryGu = "કાર્ડ સંબંધિત કામગીરી",
            descriptionEn = "New PAN Card, Corrections, and PVC printing.",
            descriptionGu = "નવું પાન કાર્ડ, સુધારો કરવા, અને પીવીસી કાર્ડ કઢાવવા.",
            documentsEn = listOf("Aadhaar Card", "Passport Photo", "Age Proof"),
            documentsGu = listOf("આધાર કાર્ડ", "પાસપોર્ટ ફોટો", "ઉંમરનો પુરાવો"),
            iconName = "CreditCard",
            popular = false
        ),
        Service(
            id = "ayushman-abha-card",
            titleEn = "Ayushman Card (PMJAY) & ABHA",
            titleGu = "આયુષ્માન કાર્ડ (PMJAY) અને આભા",
            categoryEn = "Cards",
            categoryGu = "કાર્ડ સંબંધિત કામગીરી",
            descriptionEn = "Ayushman Bharat Card enrollment and ABHA Health ID generation.",
            descriptionGu = "આયુષ્માન ભારત કાર્ડ કઢાવવા અને આભા (ABHA) હેલ્થ આઈડી બનાવવા.",
            documentsEn = listOf("Aadhaar Card", "Ration Card", "Income Certificate"),
            documentsGu = listOf("આધાર કાર્ડ", "રેશન કાર્ડ", "આવકનો દાખલો"),
            iconName = "HealthAndSafety",
            popular = true
        ),
        Service(
            id = "e-shram-card",
            titleEn = "E-Shram Card",
            titleGu = "ઇ-શ્રમ કાર્ડ",
            categoryEn = "Cards",
            categoryGu = "કાર્ડ સંબંધિત કામગીરી",
            descriptionEn = "E-Shram card registration for unorganized workers.",
            descriptionGu = "અસંગઠિત કામદારો માટે ઇ-શ્રમ કાર્ડ નોંધણી.",
            documentsEn = listOf("Aadhaar Card", "Aadhaar Linked Mobile", "Bank Passbook"),
            documentsGu = listOf("આધાર કાર્ડ", "આધાર સાથે લિંક મોબાઈલ", "બેંક પાસબુક"),
            iconName = "People",
            popular = false
        ),
        Service(
            id = "pm-kisan",
            titleEn = "PM Kisan Samman Nidhi",
            titleGu = "પીએમ કિસાન સન્માન નિધિ",
            categoryEn = "Government Schemes",
            categoryGu = "સરકારી યોજનાઓ",
            descriptionEn = "Registration and e-KYC for PM Kisan Yojna.",
            descriptionGu = "પીએમ કિસાન યોજના માટે નોંધણી અને e-KYC.",
            documentsEn = listOf("Aadhaar Card", "Bank Passbook", "Land Documents (7/12 & 8A)"),
            documentsGu = listOf("આધાર કાર્ડ", "બેંક પાસબુક", "જમીનના દસ્તાવેજો (૭/૧૨ અને ૮-અ)"),
            iconName = "Agriculture",
            popular = true
        ),
        Service(
            id = "vidhva-sahay",
            titleEn = "Widow Pension (Vidhva Sahay)",
            titleGu = "વિધવા સહાય યોજના",
            categoryEn = "Government Schemes",
            categoryGu = "સરકારી યોજનાઓ",
            descriptionEn = "Application for Widow Pension Scheme.",
            descriptionGu = "વિધવા સહાય યોજના માટે અરજી.",
            documentsEn = listOf("Aadhaar Card", "Husband Death Certificate", "Income Certificate", "Bank Passbook", "Ration Card"),
            documentsGu = listOf("આધાર કાર્ડ", "પતિના મરણનો દાખલો", "આવકનો દાખલો", "બેંક પાસબુક", "રેશન કાર્ડ"),
            iconName = "FamilyRestroom",
            popular = true
        ),
        Service(
            id = "vrudh-sahay",
            titleEn = "Old Age Pension (Vrudh Sahay)",
            titleGu = "વૃદ્ધ સહાય યોજના",
            categoryEn = "Government Schemes",
            categoryGu = "સરકારી યોજનાઓ",
            descriptionEn = "Application for Old Age Pension Scheme.",
            descriptionGu = "વૃદ્ધ સહાય યોજના (નિરાધાર વૃદ્ધ સહાય) માટે અરજી.",
            documentsEn = listOf("Aadhaar Card", "Age Proof (59+)", "Income Certificate", "Bank Passbook", "Ration Card"),
            documentsGu = listOf("આધાર કાર્ડ", "ઉંમરનો પુરાવો (59+)", "આવકનો દાખલો", "બેંક પાસબુક", "રેશન કાર્ડ"),
            iconName = "Elderly",
            popular = true
        ),
        Service(
            id = "e-kutir",
            titleEn = "Manav Kalyan Yojana (e-Kutir)",
            titleGu = "માનવ કલ્યાણ યોજના",
            categoryEn = "Government Schemes",
            categoryGu = "સરકારી યોજનાઓ",
            descriptionEn = "Application for Manav Kalyan Yojana / e-Kutir portal schemes.",
            descriptionGu = "માનવ કલ્યાણ યોજના હેઠળ સાધન સહાય માટેની અરજી.",
            documentsEn = listOf("Aadhar Card", "Ration Card", "Residence Proof", "Income Certificate", "Bank Passbook", "Photo"),
            documentsGu = listOf("આધાર કાર્ડ", "રેશન કાર્ડ", "રહેઠાણનો પુરાવો", "આવકનો દાખલો", "બેંક પાસબુક", "ફોટો"),
            iconName = "Handyman",
            popular = true
        ),
        Service(
            id = "e-nirman",
            titleEn = "E-Nirman Card & Scholarship",
            titleGu = "ઇ-નિર્માણ કાર્ડ અને શિષ્યવૃત્તિ",
            categoryEn = "Student / Scholarship",
            categoryGu = "વિદ્યાર્થી / શિષ્યવૃત્તિ",
            descriptionEn = "Registration for construction workers and their children's scholarship.",
            descriptionGu = "બાંધકામ શ્રમિકો માટે કાર્ડ અને બાળકો માટે શિષ્યવૃત્તિ.",
            documentsEn = listOf("Aadhaar Card", "Bank Passbook", "Contractor Letter", "Children Marksheets"),
            documentsGu = listOf("આધાર કાર્ડ", "બેંક પાસબુક", "કોન્ટ્રાક્ટરનો દાખલો", "બાળકોની માર્કશીટ"),
            iconName = "School",
            popular = true
        ),
        Service(
            id = "digital-gujarat",
            titleEn = "Digital Gujarat Scholarship",
            titleGu = "ડિજિટલ ગુજરાત શિષ્યવૃત્તિ",
            categoryEn = "Student / Scholarship",
            categoryGu = "વિદ્યાર્થી / શિષ્યવૃત્તિ",
            descriptionEn = "Online scholarship application for school/college students.",
            descriptionGu = "શાળા/કોલેજના વિદ્યાર્થીઓ માટે ઓનલાઈન શિષ્યવૃત્તિ અરજી.",
            documentsEn = listOf("Aadhaar Card", "Ration Card", "Marksheet", "L.C.", "Caste Cert", "Income Cert", "Bank Passbook", "Fee Receipt"),
            documentsGu = listOf("આધાર કાર્ડ", "રેશન કાર્ડ", "માર્કશીટ", "એલ.સી.", "જાતિનો દાખલો", "આવકનો દાખલો", "બેંક પાસબુક", "ફી પાવતી"),
            iconName = "MenuBook",
            popular = true
        )
    )
}
