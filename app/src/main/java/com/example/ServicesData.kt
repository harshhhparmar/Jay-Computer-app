package com.example

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.automirrored.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

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

fun getIconForName(name: String): ImageVector {
    return when (name) {
        "WorkspacePremium" -> Icons.Default.WorkspacePremium
        "Description" -> Icons.Default.Description
        "CreditCard" -> Icons.Default.CreditCard
        "VerifiedUser" -> Icons.Default.VerifiedUser
        "Favorite" -> Icons.Default.Favorite
        "People" -> Icons.Default.People
        "Agriculture" -> Icons.Default.Agriculture
        "Handshake" -> Icons.Default.Handshake
        "PersonAdd" -> Icons.Default.PersonAdd
        "HomeRepairService" -> Icons.Default.HomeRepairService
        "Construction" -> Icons.Default.Construction
        "School" -> Icons.Default.School
        "MenuBook" -> Icons.AutoMirrored.Filled.MenuBook
        "Security" -> Icons.Default.Security
        "PostAdd" -> Icons.Default.PostAdd
        "DirectionsCar" -> Icons.Default.DirectionsCar
        "AccountBalance" -> Icons.Default.AccountBalance
        "Payments" -> Icons.Default.Payments
        "Business" -> Icons.Default.Business
        "TrendingUp" -> Icons.AutoMirrored.Filled.TrendingUp
        "IdCard" -> Icons.Default.Badge
        "Globe" -> Icons.Default.Public
        "Printer" -> Icons.Default.Print
        "ShieldCheck" -> Icons.Default.Shield
        "Banknote" -> Icons.Default.Money
        else -> Icons.AutoMirrored.Filled.Article
    }
}

object ServicesData {
    val services = listOf(
        Service(
            id = "aadhaar-update",
            titleEn = "Aadhaar Card Update & Print",
            titleGu = "આધાર કાર્ડ સુધારો અને પ્રિન્ટ",
            categoryEn = "Cards",
            categoryGu = "કાર્ડ સંબંધિત કામગીરી",
            descriptionEn = "Update name, address, mobile number in Aadhaar card or get a smart PVC print.",
            descriptionGu = "આધાર કાર્ડમાં નામ, સરનામું, મોબાઈલ નંબર સુધારો અથવા સ્માર્ટ PVC પ્રિન્ટ કઢાવો.",
            documentsEn = listOf("Aadhaar Card", "Valid Proof (for update)", "Linked Mobile Number"),
            documentsGu = listOf("આધાર કાર્ડ", "માન્ય પુરાવો (સુધારા માટે)", "લિંક કરેલ મોબાઈલ નંબર"),
            iconName = "IdCard",
            popular = true
        ),
        Service(
            id = "passport-application",
            titleEn = "Passport Application",
            titleGu = "પાસપોર્ટ અરજી",
            categoryEn = "Government Documents",
            categoryGu = "સરકારી ડોક્યુમેન્ટ્સ",
            descriptionEn = "New passport application, renewal, and appointment booking.",
            descriptionGu = "નવા પાસપોર્ટ માટે અરજી, રીન્યુઅલ અને એપોઈન્ટમેન્ટ બુકિંગ.",
            documentsEn = listOf("Aadhaar Card", "PAN Card / Voter ID", "School Leaving Certificate / Birth Certificate"),
            documentsGu = listOf("આધાર કાર્ડ", "પાન કાર્ડ / ચૂંટણી કાર્ડ", "સ્કુલ લીવીંગ / જન્મનો દાખલો"),
            iconName = "Globe",
            popular = false
        ),
        Service(
            id = "police-clearance",
            titleEn = "Police Clearance Certificate (PCC)",
            titleGu = "પોલીસ ક્લિયરન્સ સર્ટિફિકેટ",
            categoryEn = "Government Documents",
            categoryGu = "સરકારી ડોક્યુમેન્ટ્સ",
            descriptionEn = "Apply for Police Clearance Certificate for visa, job or immigration.",
            descriptionGu = "વિઝા, નોકરી અથવા ઇમિગ્રેશન માટે પોલીસ ક્લિયરન્સ સર્ટિફિકેટની અરજી.",
            documentsEn = listOf("Passport", "Aadhaar Card", "Address Proof", "Photo"),
            documentsGu = listOf("પાસપોર્ટ", "આધાર કાર્ડ", "રહેઠાણનો પુરાવો", "ફોટો"),
            iconName = "ShieldCheck",
            popular = false
        ),
        Service(
            id = "money-transfer",
            titleEn = "Money Transfer & AEPS",
            titleGu = "મની ટ્રાન્સફર અને AEPS",
            categoryEn = "SBI / Banking Services",
            categoryGu = "SBI / બેન્કિંગ સેવાઓ",
            descriptionEn = "Send money instantly anywhere in India and cash withdrawal using Aadhaar (AEPS).",
            descriptionGu = "સમગ્ર ભારતમાં તરત જ પૈસા મોકલો અને આધાર કાર્ડથી રોકડ ઉપાડ (AEPS).",
            documentsEn = listOf("Bank Account Details", "Aadhaar Card (for AEPS)", "Mobile Number"),
            documentsGu = listOf("બેંક ખાતાની વિગતો", "આધાર કાર્ડ (AEPS માટે)", "મોબાઈલ નંબર"),
            iconName = "Banknote",
            popular = false
        ),
        Service(
            id = "xerox-print",
            titleEn = "Xerox, Print & Lamination",
            titleGu = "ઝેરોક્ષ, પ્રિન્ટ અને લેમિનેશન",
            categoryEn = "General Services",
            categoryGu = "સામાન્ય સેવાઓ",
            descriptionEn = "High quality color/B&W printing, xerox, lamination, and spiral binding.",
            descriptionGu = "ઉચ્ચ ગુણવત્તાવાળી કલર/B&W પ્રિન્ટિંગ, ઝેરોક્ષ, લેમિનેશન અને સ્પાઈરલ બાઈન્ડીંગ.",
            documentsEn = listOf("Document/File in Pen Drive or WhatsApp"),
            documentsGu = listOf("પેન ડ્રાઈવ અથવા વોટ્સએપમાં ડોક્યુમેન્ટ/ફાઈલ"),
            iconName = "Printer",
            popular = false
        ),

        Service(
            id = "income-certificate",
            titleEn = "Income Certificate",
            titleGu = "આવકનો દાખલો",
            categoryEn = "Government Documents",
            categoryGu = "સરકારી ડોક્યુમેન્ટ્સ",
            descriptionEn = "Income Certificate required for scholarship, admission, etc.",
            descriptionGu = "આવકનો દાખલો સ્કોલરશિપ, એડમિશન વગેરે માટે જરૂરી છે.",
            documentsEn = listOf("Form and Photo", "Ration Card Copy", "Talati's Income Certificate", "Last Light Bill", "Aadhaar Card"),
            documentsGu = listOf("ફોર્મ અને ફોટો", "રેશન કાર્ડની નકલ", "તલાટીનો આવકનો દાખલો", "છેલ્લું લાઈટ બિલ", "આધારકાર્ડ"),
            iconName = "WorkspacePremium",
            popular = false
        ),
        Service(
            id = "caste-certificate",
            titleEn = "Caste Certificate",
            titleGu = "જાતિનો દાખલો",
            categoryEn = "Government Documents",
            categoryGu = "સરકારી ડોક્યુમેન્ટ્સ",
            descriptionEn = "Caste Certificate for educational and government purposes.",
            descriptionGu = "શૈક્ષણિક અને સરકારી હેતુઓ માટે જાતિનો દાખલો.",
            documentsEn = listOf("Form and Photo", "Ration Card Copy", "School Leaving Certificate", "Father/Brother/Sister's School Leaving", "Last Light Bill", "Talati's Caste Certificate", "Aadhaar Card"),
            documentsGu = listOf("ફોર્મ અને ફોટો", "રેશન કાર્ડની નકલ", "સ્કુલ લીવીંગ સર્ટી", "પિતા / ભાઈ / બહેનનું સ્કુલ લીવીંગ", "છેલ્લું લાઈટ બિલ", "તલાટીનો જાતિનો દાખલો", "આધારકાર્ડ"),
            iconName = "WorkspacePremium",
            popular = false
        ),
        Service(
            id = "domicile-certificate",
            titleEn = "Domicile Certificate",
            titleGu = "ડોમિસાઈલ સર્ટી",
            categoryEn = "Government Documents",
            categoryGu = "સરકારી ડોક્યુમેન્ટ્સ",
            descriptionEn = "Domicile Certificate for proving residence in Gujarat state.",
            descriptionGu = "ગુજરાત રાજ્યમાં રહેઠાણ સાબિત કરવા માટે ડોમિસાઈલ સર્ટી.",
            documentsEn = listOf("Form and Photo", "Ration Card Copy", "School Leaving Certificate", "Talati's 10-year Residence Certificate", "Residence Affidavit (Sogandnamu)", "Last Light Bill", "Birth Certificate", "Police Station Certificate", "Aadhaar Card"),
            documentsGu = listOf("ફોર્મ અને ફોટો", "રેશન કાર્ડની નકલ", "સ્કુલ લીવીંગ સર્ટી", "તલાટીનો ૧૦ વર્ષનો રહેઠાણનો દાખલો", "રહેઠાણનું સોગંદનામું", "છેલ્લું લાઈટ બિલ", "જન્મનો દાખલો", "પોલીસ સ્ટેનો દાખલો", "આધારકાર્ડ"),
            iconName = "WorkspacePremium",
            popular = true
        ),
        Service(
            id = "ews-ncl-certificate",
            titleEn = "EWS / Non-Creamy Layer",
            titleGu = "EWS / નોન-ક્રીમી લેયર દાખલો",
            categoryEn = "Government Documents",
            categoryGu = "સરકારી ડોક્યુમેન્ટ્સ",
            descriptionEn = "EWS and Non-Creamy Layer certificates for unreserved/reserved categories.",
            descriptionGu = "બિન-અનામત વર્ગ માટે EWS અને આરક્ષિત વર્ગ માટે નોન-ક્રીમી લેયર દાખલો.",
            documentsEn = listOf("Form and Photo", "Ration Card Copy", "School Leaving Certificate", "Income Certificate (Last 3 years for NCL)", "Talati's Caste/EWS Certificate", "Last Light Bill", "Aadhaar Card"),
            documentsGu = listOf("ફોર્મ અને ફોટો", "રેશન કાર્ડની નકલ", "સ્કુલ લીવીંગ સર્ટી", "આવકનો દાખલો (NCL માટે છેલ્લા ૩ વર્ષનો)", "તલાટીનો દાખલો", "છેલ્લું લાઈટ બિલ", "આધારકાર્ડ"),
            iconName = "WorkspacePremium",
            popular = true
        ),
        Service(
            id = "ration-card",
            titleEn = "Ration Card Support",
            titleGu = "રેશન કાર્ડ",
            categoryEn = "Cards",
            categoryGu = "કાર્ડ સંબંધિત કામગીરી",
            descriptionEn = "Apply for new ration card, name addition/removal, and ration card correction.",
            descriptionGu = "નવું રેશન કાર્ડ કઢાવવા, નામ ઉમેરવા/કમી કરવા, અને જરૂરી સુધારા કરવા.",
            documentsEn = listOf("Aadhaar Card of all members", "Light Bill", "Income Proof", "Passport Photo", "Old Ration Card (if any)"),
            documentsGu = listOf("પરિવારના તમામ સભ્યોના આધાર કાર્ડ", "લાઈટ બિલ", "આવકનો પુરાવો", "પાસપોર્ટ ફોટો", "જૂનું રેશન કાર્ડ (જો હોય તો)"),
            iconName = "Description",
            popular = true
        ),
        Service(
            id = "pancard",
            titleEn = "PAN Card Services",
            titleGu = "પાન કાર્ડ",
            categoryEn = "Cards",
            categoryGu = "કાર્ડ સંબંધિત કામગીરી",
            descriptionEn = "New PAN Card application, corrections, or reprint services.",
            descriptionGu = "નવું પાન કાર્ડ, પાન કાર્ડમાં સુધારો, અને ખોવાયેલ પાન કાર્ડ કઢાવવા.",
            documentsEn = listOf("Aadhaar Card", "2 Passport Size Photos"),
            documentsGu = listOf("આધાર કાર્ડ", "2 પાસપોર્ટ સાઈઝના ફોટા"),
            iconName = "CreditCard",
            popular = true
        ),
        Service(
            id = "voter-id",
            titleEn = "Voter ID Services",
            titleGu = "ચૂંટણી કાર્ડ",
            categoryEn = "Cards",
            categoryGu = "કાર્ડ સંબંધિત કામગીરી",
            descriptionEn = "Apply for a new Voter ID, correct details, or replace lost card.",
            descriptionGu = "નવું ચૂંટણી કાર્ડ, સુધારો કરવા, અને પીવીસી કાર્ડ કઢાવવા.",
            documentsEn = listOf("Aadhaar Card", "Passport Photo", "Age Proof"),
            documentsGu = listOf("આધાર કાર્ડ", "પાસપોર્ટ ફોટો", "ઉંમરનો પુરાવો"),
            iconName = "VerifiedUser",
            popular = false
        ),
        Service(
            id = "ayushman-abha-card",
            titleEn = "Ayushman Card (PMJAY) & ABHA Card",
            titleGu = "આયુષ્માન કાર્ડ (PMJAY) અને આભા કાર્ડ",
            categoryEn = "Cards",
            categoryGu = "કાર્ડ સંબંધિત કામગીરી",
            descriptionEn = "Ayushman Bharat Card enrollment and ABHA Health ID generation.",
            descriptionGu = "આયુષ્માન ભારત કાર્ડ કઢાવવા અને આભા (ABHA) હેલ્થ આઈડી બનાવવા.",
            documentsEn = listOf("Aadhaar Card", "Ration Card", "Income Certificate (if applicable)"),
            documentsGu = listOf("આધાર કાર્ડ", "રેશન કાર્ડ", "આવકનો દાખલો (જો હોય તો)"),
            iconName = "Favorite",
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
            descriptionGu = "વિધવા સહાય (ગંગા સ્વરૂપ આર્થિક સહાય) યોજના માટે અરજી.",
            documentsEn = listOf("Aadhaar Card", "Husband Death Certificate", "Income Certificate", "Bank Passbook", "Ration Card"),
            documentsGu = listOf("આધાર કાર્ડ", "પતિના મરણનો દાખલો", "આવકનો દાખલો", "બેંક પાસબુક", "રેશન કાર્ડ"),
            iconName = "Handshake",
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
            documentsEn = listOf("Aadhaar Card", "Age Proof", "Income Certificate", "Bank Passbook", "Ration Card"),
            documentsGu = listOf("આધાર કાર્ડ", "ઉંમરનો પુરાવો (59+ વર્ષ)", "આવકનો દાખલો", "બેંક પાસબુક", "રેશન કાર્ડ"),
            iconName = "PersonAdd",
            popular = true
        ),
        Service(
            id = "e-kutir",
            titleEn = "Manav Kalyan Yojana",
            titleGu = "માનવ કલ્યાણ યોજના",
            categoryEn = "Government Schemes",
            categoryGu = "સરકારી યોજનાઓ",
            descriptionEn = "Application for Manav Kalyan Yojana / e-Kutir portal schemes.",
            descriptionGu = "માનવ કલ્યાણ યોજના હેઠળ સાધન સહાય માટેની અરજી.",
            documentsEn = listOf("Aadhar Card and Ration Card", "Residence Proof (Electricity Bill, Rent Agreement, or Voter ID)", "Caste Certificate and Annual Income Certificate", "Bank Passbook & Passport Size Photo", "Vocational/Trade Training Certificate (If any)", "E-Shram Card", "Self-declaration"),
            documentsGu = listOf("આધાર કાર્ડ અને રેશન કાર્ડ", "રહેઠાણનો પુરાવો (લાઇટ બિલ, ભાડા કરાર, અથવા ચૂંટણી કાર્ડ)", "જાતિનો દાખલો અને આવકનો દાખલો", "બેંક પાસબુક અને પાસપોર્ટ સાઇઝ ફોટો", "તાલીમ લીધી હોય તો તેનું પ્રમાણપત્ર", "ઈ-શ્રમ કાર્ડ", "બાહેધરી પત્રક (સોગંદનામું)"),
            iconName = "HomeRepairService",
            popular = true
        ),
        Service(
            id = "e-nirman-scholarship",
            titleEn = "E-Nirman Card & Scholarship",
            titleGu = "ઇ-નિર્માણ કાર્ડ અને શિષ્યવૃત્તિ",
            categoryEn = "Student / Labour / Scholarship",
            categoryGu = "વિદ્યાર્થી / શ્રમિક / શિષ્યવૃત્તિ",
            descriptionEn = "Registration for construction workers and their children's scholarship.",
            descriptionGu = "બાંધકામ શ્રમિકો માટે કાર્ડ અને તેમના બાળકો માટે શિષ્યવૃત્તિ નોંધણી.",
            documentsEn = listOf("Aadhaar Card", "Bank Passbook", "Contractor Letter (90 days)", "Children Marksheets"),
            documentsGu = listOf("આધાર કાર્ડ", "બેંક પાસબુક", "કોન્ટ્રાક્ટરનો દાખલો (૯૦ દિવસ)", "બાળકોની માર્કશીટ"),
            iconName = "Construction",
            popular = true
        ),
        Service(
            id = "digital-gujarat-scholarship",
            titleEn = "Digital Gujarat Scholarship",
            titleGu = "ડિજિટલ ગુજરાત શિષ્યવૃત્તિ",
            categoryEn = "Student / Labour / Scholarship",
            categoryGu = "વિદ્યાર્થી / શ્રમિક / શિષ્યવૃત્તિ",
            descriptionEn = "Online scholarship application for school/college students.",
            descriptionGu = "શાળા/કોલેજના વિદ્યાર્થીઓ માટે ઓનલાઈન શિષ્યવૃત્તિ અરજી.",
            documentsEn = listOf("Aadhaar Card", "Ration Card", "Std 10, 12 & Last Marksheet", "School Leaving Certificate (L.C.)", "Caste Certificate", "Income Certificate", "Bank Passbook", "Passport Size Photo", "School/College Fee Receipt", "Bonafide Certificate (if required)"),
            documentsGu = listOf("આધાર કાર્ડ", "રેશન કાર્ડ", "ધો. ૧૦, ૧૨ અને છેલ્લી માર્કશીટ", "એલ.સી.", "જાતિનો દાખલો", "આવકનો દાખલો", "બેંક પાસબુક", "ફોટો", "શાળા કે કોલેજની ફી ભર્યાની પાવતી", "બોનોફાઇડ (જો જરૂરી હોય તો)"),
            iconName = "School",
            popular = true
        ),
        Service(
            id = "rte-admission",
            titleEn = "RTE Admission",
            titleGu = "RTE એડમિશન",
            categoryEn = "Student / Labour / Scholarship",
            categoryGu = "વિદ્યાર્થી / શ્રમિક / શિષ્યવૃત્તિ",
            descriptionEn = "RTE (Right to Education) free admission online form.",
            descriptionGu = "રાઈટ ટુ એજ્યુકેશન (RTE) અંતર્ગત મફત શિક્ષણ માટેના ઓનલાઈન ફોર્મ.",
            documentsEn = listOf("Child Birth Certificate", "Aadhaar Card of Child & Parents", "Income Certificate", "Address Proof", "Caste Certificate"),
            documentsGu = listOf("બાળકનો જન્મનો દાખલો", "બાળક અને માતાપિતાનું આધાર કાર્ડ", "આવકનો દાખલો", "રહેઠાણનો પુરાવો", "જાતિનો દાખલો"),
            iconName = "MenuBook",
            popular = true
        ),
        Service(
            id = "lic-premium",
            titleEn = "LIC Premium Support & Payment",
            titleGu = "LIC પ્રીમિયમ પેમેન્ટ",
            categoryEn = "LIC Services",
            categoryGu = "LIC સેવાઓ",
            descriptionEn = "Online payment and receipt generation for LIC policies.",
            descriptionGu = "તમામ LIC પોલિસીઓ માટે ઓનલાઈન પ્રીમિયમ પેમેન્ટ અને રસીદ.",
            documentsEn = listOf("Policy Number", "Mobile Number", "Email ID"),
            documentsGu = listOf("પોલિસી નંબર", "મોબાઈલ નંબર", "ઈમેલ આઈડી"),
            iconName = "Security",
            popular = true
        ),
        Service(
            id = "lic-new-policy",
            titleEn = "New LIC Policy",
            titleGu = "નવી LIC પોલિસી",
            categoryEn = "LIC Services",
            categoryGu = "LIC સેવાઓ",
            descriptionEn = "Guidance and application for new LIC policies suited to your needs.",
            descriptionGu = "તમારી જરૂરિયાત મુજબની નવી LIC પોલિસી માટે માર્ગદર્શન અને અરજી.",
            documentsEn = listOf("Aadhaar Card", "PAN Card", "Bank Details", "Passport Photo"),
            documentsGu = listOf("આધાર કાર્ડ", "પાન કાર્ડ", "બેંક ખાતાની વિગતો", "પાસપોર્ટ ફોટો"),
            iconName = "PostAdd",
            popular = false
        ),
        Service(
            id = "vehicle-insurance",
            titleEn = "Vehicle Insurance (Two/Four Wheeler)",
            titleGu = "વાહન વીમો (ટુ/ફોર વ્હીલર)",
            categoryEn = "Insurance Services",
            categoryGu = "વીમા સેવાઓ",
            descriptionEn = "New and renewal of two-wheeler, four-wheeler, and commercial vehicle insurance.",
            descriptionGu = "નવો અને રીન્યુઅલ વાહન વીમો (ટુ વ્હીલર, ફોર વ્હીલર અને કોમર્શિયલ વાહન).",
            documentsEn = listOf("RC Book", "Old Policy (if renewal)"),
            documentsGu = listOf("આરસી બુક", "જૂની પોલિસી (જો રીન્યુઅલ હોય તો)"),
            iconName = "DirectionsCar",
            popular = true
        ),
        Service(
            id = "new-bank-account",
            titleEn = "New Bank Account Opening",
            titleGu = "નવું બેંક ખાતું ખોલવા",
            categoryEn = "SBI / Banking Services",
            categoryGu = "SBI / બેન્કિંગ સેવાઓ",
            descriptionEn = "Assistance in opening zero balance and regular savings bank accounts.",
            descriptionGu = "ઝીરો બેલેન્સ અને રેગ્યુલર સેવિંગ્સ બેંક એકાઉન્ટ ખોલવામાં સહાય.",
            documentsEn = listOf("Aadhaar Card", "PAN Card", "2 Passport Photos", "Mobile Number"),
            documentsGu = listOf("આધાર કાર્ડ", "પાન કાર્ડ", "2 પાસપોર્ટ ફોટા", "મોબાઈલ નંબર"),
            iconName = "AccountBalance",
            popular = true
        ),
        Service(
            id = "personal-loan",
            titleEn = "Personal & Business Loan",
            titleGu = "પર્સનલ અને બિઝનેસ લોન",
            categoryEn = "Loan Services",
            categoryGu = "લોન સેવાઓ",
            descriptionEn = "Guidance and application processing for personal and business loans.",
            descriptionGu = "પર્સનલ અને બિઝનેસ લોન માટે માર્ગદર્શન અને અરજી પ્રક્રિયા.",
            documentsEn = listOf("Aadhaar Card", "PAN Card", "Last 6 Months Bank Statement", "ITR / Salary Slip"),
            documentsGu = listOf("આધાર કાર્ડ", "પાન કાર્ડ", "છેલ્લા 6 મહિનાનું બેંક સ્ટેટમેન્ટ", "ITR / સેલરી સ્લિપ"),
            iconName = "Payments",
            popular = false
        ),
        Service(
            id = "driving-license",
            titleEn = "Driving License",
            titleGu = "ડ્રાઈવિંગ લાયસન્સ",
            categoryEn = "RTO Services",
            categoryGu = "RTO સેવાઓ",
            descriptionEn = "Learner license, driving license renewal, duplicate license.",
            descriptionGu = "કાચું લાયસન્સ, પાકું લાયસન્સ, રીન્યુઅલ.",
            documentsEn = listOf("Aadhaar Card", "Passport Photo", "Age/Address Proof"),
            documentsGu = listOf("આધાર કાર્ડ", "પાસપોર્ટ ફોટો", "ઉંમર/સરનામાનો પુરાવો"),
            iconName = "DirectionsCar",
            popular = true
        ),
        Service(
            id = "msme-udyam",
            titleEn = "MSME / Udyam Registration",
            titleGu = "ઉદ્યોગ આધાર / MSME",
            categoryEn = "Tax & Finance",
            categoryGu = "કર અને નાણાકીય",
            descriptionEn = "Udyam registration for small and medium enterprises.",
            descriptionGu = "નાના અને મધ્યમ ઉદ્યોગો માટે ઉદ્યોગ આધાર નોંધણી.",
            documentsEn = listOf("Aadhaar Card", "PAN Card", "Bank Account Details"),
            documentsGu = listOf("આધાર કાર્ડ", "પાન કાર્ડ", "બેંક ખાતાની વિગતો"),
            iconName = "Business",
            popular = false
        ),
        Service(
            id = "income-tax-return",
            titleEn = "Income Tax Return (ITR)",
            titleGu = "ઇન્કમ ટેક્સ રિટર્ન (ITR)",
            categoryEn = "Tax & Finance",
            categoryGu = "કર અને નાણાકીય",
            descriptionEn = "Filing of annual Income Tax Returns for individuals and businesses.",
            descriptionGu = "વ્યક્તિઓ અને ઉદ્યોગો માટે વાર્ષિક ઇન્કમ ટેક્સ રિટર્ન ફાઇલિંગ.",
            documentsEn = listOf("PAN Card", "Aadhaar Card", "Form 16 / Bank Statements", "Investment Proofs"),
            documentsGu = listOf("પાન કાર્ડ", "આધાર કાર્ડ", "ફોર્મ 16 / બેંક સ્ટેટમેન્ટ", "રોકાણના પુરાવા"),
            iconName = "TrendingUp",
            popular = false
        )
    )
}
