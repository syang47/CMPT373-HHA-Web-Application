import { createI18n } from 'vue-i18n'

const i18n = createI18n({
  fallbackLocale: 'en',
  messages: {
    fr: {
      header: {
        loginOut: "CONNEXION / DEconnexion",
        register: "S'INSCRIRE",
        showDepartments: "MONTRER LES DÉPARTEMENTS",
        showData: "AFFICHER LES DONNÉES",
        addAnnouncement: "AJOUTER UNE ANNONCE",
      },
      loginPage: {
        login: "Connexion",
        username: "Nom d'utilisateur'",
        password: "Mot de passe",
        submit: "NOUS FAIRE PARVENIR",
        register: "S'INSCRIRE",
      },
      registerPage: {
        registration: "Enregistrement",
        username: "Nom d'utilisateur",
        password: "Mot de passe",
        selectDept: "Sélectionnez un département:",
        deptHeadMedDir: "Chef de service/Directeur médical?",
        mbal6c: "Doit être au moins 6 caractères!",
        mbal4c: "Doit comporter au moins 4 caractères!",
        role: "Rôle",
        signUp: "S'INSCRIRE",
        userReq: "Nom d'utilisateur est nécessaire!",
        roleReq: "Le rôle est requis!",
        passReq: "Mot de passe requis!",
        mbm20c: "Doit contenir un maximum de 20 caractères!",
        mbm40c: "Doit contenir au maximum 40 caractères!",
        admin: "administrateur",
      },
      announcementPage: {
        addAnnouncement: "Ajouter une annonce",
        monthlyAward: "Récompense mensuelle",
        addPhoto: "Ajouter une photo:",
        annualAward: "Prix ​​annuel",
        submit: "Soumettre",
      },
      homePage: {
        leaderBoard: "CLASSEMENT",
        nicuPaed: "USIN/PAED",
        maternity: "MATERNITÉ",
        rehab: "DÉSINTOX",
        communityHealth: "SANTÉ COMMUNAUTAIRE",
        messageBoard: "TABLEAU DE MESSAGES",
        caseStudy: "ÉTUDE DE CAS",
      },
      msppData: {
        msppForm: "Formulaire de saisie de données MSPP",
        rehabForm: "Formulaire de saisie de données de réadaptation",
        nicupaedForm: "Formulaire de saisie de données USIN/PAED",
        communityHealthForm: "Formulaire de saisie des données de santé communautaire",
        bedsAvailable: "Lits disponibles",
        bedDays: "Jours de lit",
        patientDays: "Journées-patients",
        hospitalised: "Hospitalisé",
        dischargedAlive: "Déchargé vivant",
        diedBefore48h: "Décédé avant 48h",
        diedAfter48h: "Décédé après 48h",
        daysHospitalised: "Jours d'hospitalisation",
        referrals: "Références",
        transfers: "Transferts",
        selfDischarged: "Autodéchargé",
        stayedInTheWard: "Resté dans la salle",
        admissions: "Admissions",
        births: "Naissances",
        postNatal: "Suivi Post Natal",
        complications: "Complications",
        numberOfStillborns: "Nombre de mort-nés",
        maternalDeathInTheHospital: "Mort maternelle à l'hôpital",
        supportForWifeAndMother: "Soutien à l'épouse et à la mère",
        supportForWomenHospital: "Soutien à l'hôpital des femmes",
        otherServices: "Autres services",
        deliveries: "Accouchments",
        submit: "NOUS FAIRE PARVENIR",
        normal: "Ordinaire",
        cesarean: "césarienne",
        instruments: "Instruments",
        weight1_5: "Poids <1.5kg",
        weight1_5To2_5: "1.5kg ⩽ Poids <2.5kg",
        weight2_5Up: "2.5kg et plus",
        notWeighted: "Non pesées",
        immediatelyBreastfed: "Milses au sein immédiatement",
        skinToSkinTherapy: "Bénéficares de méthode Kangourou",
        bFWomenVitA: "Femmes allaitantes recevant de la vitamine A",
        bFWomenMUAC: "Femmes allaitantes avec PB <210mm",
        bFWomenMalnutrition: "Femmes allaitantes avec MAM/MAS prises en charge",
        domesticVisits: "Visites domicllaries 0-3 jours",
        postNatalConsultations: "Consultations post natales",
        hours0_6: "0-6 heures",
        hoursDays7_6: "7h-6 jours",
        days7_42: "7-42 jours",
        compRec: "Nombre de complications obstétricales enregistrées",
        compRef: "Nombre de complications obstétricales référées",
        macerated: "macéré",
        notMacerated: "Non macéré",
        inHospital: "À l'hôpital",
        inTheCommunity: "Dans la communauté",
        periodOfPregnancy: "Période de grossesse",
        months0_3: "0-3 mois",
        months4_6: "4-6 mois",
        months7_9: "7-9 mois",
        totalVisits: "Nombre total de visites",
        visit1: "1ère visite",
        visit2: "2e visite",
        visit3: "3ème visite",
        visit4: "4ème visite",
        visit5Up: "5e plus Visite",
        total: "Le total",
        numberOfPregnanciesAtRisk: "Nombre de grossesses à risque",
        caseAnemia: "Cas d'anémie chez les femmes enceintes",
        pWIronFolate: "Femmes enceintes recevant du folate de fer",
        pWIronDef: "Les femmes enceintes traitées pour l'anémie ferriprive",
        pWBirthPlan: "Femmes enceintes avec un projet de naissance",
        pWMalaria: "Femmes enceintes atteintes de paludisme confirmé traitées par la chloroquine",
        pWMosquito: "Femmes enceintes qui ont reçu une moustiquaire imprégnée",
        pWMuac: "Circonférence du bras mi-supérieur pour femmes enceintes < 210 mm",
        wIronFolate: "Autres femmes recevant du folate de fer",
        wAceticAcid: "Femmes recevant l'inspection de l'acide acétique",
        wSmearTest: "Femmes positives après frottis",
        wSmearTakenCare: "Test de frottis positif pour femmes pris en charge",
        wPostabortion: "Femmes recevant des soins après avortement",
        ageOfMothers: "Âge des mères",
        years15: "<15 ans",
        years15_19: "15-19 ans",
        years20_24: "20-24 ans",
        years25_29: "25-29 ans",
        years30Up: "30 ans et plus",
        unknown: "Inconnue",
        labourManagement: "La gestion de la main-d'œuvre",
        useOfPartograph: "Utilisation du partogramme",
        managementLabour3rdYear: "Gestion active de la 3e phase du travail",
        hospitalisedNICU: "USIN hospitalisé",
        hospitalisedPAED: "PAED hospitalisé",
        ofTotalDischargedNICU: "Du nombre total de sorties : USIN sorties",
        diedNICUBefore48h: "Décédé à l'USIN avant 48h",
        diedPAEDBefore48h: "Décédé au PAED avant 48h",
        diedNICUAfter48h: "Décédé à l'USIN après 48h",
        diedPAEDAfter48h: "Décédé dans le PAED après 48h",
        reasonSelfDischarge: "Raison de l'autodécharge",
        financeCare: "Finances : partez car vous ne pouvez pas vous permettre des soins",
        financeAvoidPay: "Finances : à gauche pour éviter de payer",
        religiousCultural: "Religieux / Culturel",
        personalFamily: "Personnel / Famille",
        other: "Autre",
        wherePatientsComeFrom: "D'où viennent les patients ?",
        quMo: "Quartier Morin",
        capHai: "Cap Haïtien",
        deptNord: "Département du Nord",
        otherDept: "Autres départements: ",
        ageOfInfant: "Âge du nourrisson admis",
        extremePreterm: "Extrêmement prématuré (moins de 28 semaines)",
        veryPreterm: "Très prématuré (28 à 32 semaines)",
        modToLatePreterm: "Prématuré modéré à tardif (32 à 37 semaines)",
        fullTerm: "Terme complet (37 semaines et plus)",
        olderThanNeonate: "Plus âgé que le nouveau-né (> 4 semaines)",
        age4w_5y: "Âge 4 semaines - 5 ans",
        age6_11: "6-11 ans",
        age12_18: "12-18 ans",
        gender: "Genre",
        male: "Mâle",
        female: "Femelle",
        mainCond: "État principal",
        respiratoryArrest: "Arrêt respiratoire",
        traumaticInjury: "Blessure traumatique",
        septicShock: "Choc septique",
        hypoShock: "Choc hypovolémique",
        seizureConvulsion: "Saisies/Convulsions",
        poisoning: "Empoisonnement",
        altMentalStatus: "État mental altéré",
        gastro: "Gastro-entérite",
        hemorrhage: "Hémorragie",
        hypothermia: "Hypothermie",
        cardiacAnomaly: "Anomalie cardiaque congénitale",
        otherAnomaly: "Autre anomalie congénitale",
        malnutrition: "Malnutrition",
        meningitis: "Méningite",
        communityPneum: "Pneumonie communautaire",
        aspirationPneum: "Pneumonie par aspiration",
        modPrematurity: "Prématurité modérée (32-36 semaines de gestation)",
        severePrematurity: "Prématurité sévère (moins de 32 semaines)",
        otherMedical: "Autre médical: ",
        numberOfOutPatients: "Nombre de patients externes",
        age: "Âge",
        boy: "Garçon",
        girl: "Fille",
        birthControl: "Clients PF", // Wrong?
        methodsF: "Méthodes/Sexe pour les femmes",
        methodsM: "Méthodes/Sexe pour les hommes",
        ocp: "PC",
        patch: "PP",
        depoInjection: "Dépoprovera",
        implant: "Implant",
        IUD: "DIU (stèrilet)",
        vaginalRing: "Collier",
        bfAsBirthControl: "MAMA",
        femaleCondom: "Condom",
        sterilisation: "Ligature",
        maleCondom: "Condom",
        vasectomy: "Vasectomie",
        sterilisationAmount: "Nombre de stérilisations",
        vasectomyAmount: "Nombre de vasectomies",
        accepting: "Acceptants",
        totalUsers: "Total utilisateurs",
        years25: "<25 ans",
        years25Up: "25 ans et plus",
        contraceptivesDist: "Contraceptifs distribués",
        quantity: "Quantité",
        daysOutStock: "Nbre de jours rupture de stocks/ mois",
        ocpCycle: "PC Cycles",
        patchCycle: "PP Cycles",
        depoInjectionVial: "Dépoprovera Flacons",
        implantPacket: "Paquets d'implants",
        IUDPiece: "DIU (stèrilet) Pièces",
        vaginalRingPiece: "Collier Pièces",
        femaleCondomPiece: "morceaux de préservatif féminin",
        maleCondomPiece: "morceaux de préservatif masculin",
      },
      departmentPage: {
        nicupaed: "USIN/PAED",
        maternity: "Maternité",
        rehab: "Désintox",
        communityHealth: "Santé communautaire",
        caseStudy: "Étude de cas",
        dueDate: "Date d'échéance",
        dataInput: "Entrée de données",
        employeeOfTheMonth: "Employé du mois",
        someWords: "Quelques mots..",
        biomechSupport: "Soutien biomécanique",
        departmentPoints: "Points de service",
        monthly: "Mensuel: ",
        annually: "Annuellement: ",
      },
      leaderBoard: {
        leadersBoard: "Conseil des dirigeants",
        monthlyAward: "Récompense mensuelle",
        annualAward: "Prix ​​annuel",
        position: "Position",
        department: "département",
        points: "Points",
        caseStudyOTM: "Étude de cas du mois",
      },
      dataInput: {
        awards: "Récompenses",
        monthly: "Mensuel",
        annual: "Annuel",
        submit: "Soumettre",
      },
      caseStudyForm: {
        caseStudyForm: "Formulaire d'inscription à l'étude de cas",
        selectCSType: "Sélectionnez un type d'étude de cas: ",
        pStory: "Témoignage de patients",
        pName: "Le nom du patient",
        pAge: "Âge du patient",
        pFrom: "D'où vient le patient?",
        pChoose: "Pourquoi le patient a-t-il choisi de venir au HCBH ?",
        pHowLongHCBH: "Combien de temps sont-ils restés à HCBH?",
        diagnosis: "Quel a été leur diagnostic ?",
        morePersonalElements: "Ajoutez des éléments plus personnels à l'histoire, une citation du patient/membre de la famille, etc.",
        sRecognition: "Reconnaissance du personnel",
        sName: "Nom du personnel",
        roleJob: "Rôle/Titre du poste",
        whatDept: "Dans quel service ce membre du personnel travaille-t-il?",
        sHowLongHCBH: "Depuis combien de temps travaillent-ils chez HCBH?",
        enjoyHCBH: "Qu'est-ce qu'ils aiment le plus dans leur travail chez HCBH ?",
        sRecognise: "Pourquoi cette personne est-elle reconnue ? Acte de gentillesse? Anniversaire? etc.",
        tSession: "Session de formation",
        tDate: "Date de formation",
        tAbout: "Sur quoi s'est déroulée la formation?",
        tConducted: "Qui a dirigé la formation?",
        tAttend: "Qui a suivi la formation?",
        tBenefit: "Comment la formation bénéficiera-t-elle à HCBH et à son personnel?",
        generalSummary: "Inclure un résumé général de la formation, son succès, etc.",
        eReceived: "Équipement reçu",
        eWhat: "Quel équipement a été reçu?",
        eDept: "Quel service a reçu le matériel?",
        eFrom: "De qui provenait l'équipement?",
        eDonatePurchase: "L'équipement a-t-il été donné ou acheté?",
        eDo: "A quoi sert ce nouvel équipement ?",
        eBenefit: "Inclure qui bénéficiera de cet équipement, quelle valeur il ajoute à HCBH, etc.",
        other: "Autre",
        eExtra: "Incluez tout ce qui ne rentre dans aucune des catégories.",
        disclaimer: "Cette personne a donné la permission de partager son histoire et sa photo dans les communications HHA, y compris les plateformes en ligne.",
        addPhoto: "Ajouter une photo: ",
        submit: "Soumettre",
      },
    },

    en: {
      header: {
        loginOut: "LOG IN / LOG OUT",
        register: "REGISTER",
        showDepartments: "SHOW DEPARTMENTS",
        showData: "SHOW DATA",
        addAnnouncement: "ADD ANNOUNCEMENT",
      },
      loginPage: {
        login: "Login",
        username: "Username",
        password: "Password",
        submit: "SUBMIT",
        register: "REGISTER",
      },
      registerPage: {
        registration: "Registration",
        username: "Username",
        password: "Password",
        selectDept: "Select A Department:",
        deptHeadMedDir: "Department Head/Medical Director?",
        mbal6c: "Must be at least 6 characters!",
        mbal4c: "Must be at least 4 characters!",
        role: "Role",
        signUp: "SIGN UP",
        userReq: "Username is required!",
        roleReq: "Role is required!",
        passReq: "Password is required!",
        mbm20c: "Must be maximum of 20 characters!",
        mbm40c: "Must be maximum of 40 characters!",
        admin: "admin",
      },
      announcementPage: {
        addAnnouncement: "Add an Announcement",
        monthlyAward: "Monthly Award",
        addPhoto: "Add a Photo:",
        annualAward: "Annual Award",
        submit: "Submit",
      },
      homePage: {
        leaderBoard: "LEADER BOARD",
        nicuPaed: "NICU/PAED",
        maternity: "MATERNITY",
        rehab: "REHAB",
        communityHealth: "COMMUNITY HEALTH",
        messageBoard: "MESSAGE BOARD",
        caseStudy: "CASE STUDY",
      },
      msppData: {
        msppForm: "MSPP Data Entry Form",
        rehabForm: "Rehab Data Entry Form",
        nicupaedForm: "NICU/PAED Data Entry Form",
        communityHealthForm: "Community Health Data Entry Form",
        bedsAvailable: "Beds Available",
        bedDays: "Bed Days",
        patientDays: "Patient Days",
        hospitalised: "Hospitalised",
        dischargedAlive: "Discharged Alive",
        diedBefore48h: "Died Before 48h",
        diedAfter48h: "Died After 48h",
        daysHospitalised: "Days Hospitalised",
        referrals: "Referrals",
        transfers: "Transfers",
        selfDischarged: "Self Discharged",
        stayedInTheWard: "Stayed In The Ward",
        admissions: "Admissions",
        births: "Births",
        postNatal: "Post Natal",
        complications: "Complications",
        numberOfStillborns: "Number of Stillborns",
        maternalDeathInTheHospital: "Maternal death in the hospital",
        supportForWifeAndMother: "Support for Wife and Mother",
        supportForWomenHospital: "Support for women hospital",
        otherServices: "Other Services",
        deliveries: "Deliveries",
        submit: "SUBMIT",
        normal: "Normal",
        cesarean: "Cesarean",
        instruments: "Instruments",
        weight1_5: "Weight<1.5kg",
        weight1_5To2_5: "1.5kg⩽Weight<2.5kg",
        weight2_5Up: "2.5kg⩾Weight",
        notWeighted: "Not Weighted",
        immediatelyBreastfed: "Immediately breastfed",
        skinToSkinTherapy: "Skin to Skin Therapy",
        bFWomenVitA: "Breastfeeding Women Receiving Vitamin A",
        bFWomenMUAC: "Breastfeeding Women with MUAC<210mm",
        bFWomenMalnutrition: "Breastfeeding Women with Malnutrition Support",
        domesticVisits: "Domestic Visits in 0-3 Days",
        postNatalConsultations: "Post natal consultations",
        hours0_6: "0-6 hours",
        hoursDays7_6: "7h-6 days",
        days7_42: "7-42 days",
        compRec: "Number of obstetric complications recorded",
        compRef: "Number of obstetric complications referred",
        macerated: "Macerated",
        notMacerated: "Not Macerated",
        inHospital: "In Hospital",
        inTheCommunity: "In the Community",
        periodOfPregnancy: "Period of pregnancy",
        months0_3: "0-3 Months",
        months4_6: "4-6 Months",
        months7_9: "7-9 Months",
        totalVisits: "Total visits",
        visit1: "1st Visit",
        visit2: "2nd Visit",
        visit3: "3rd Visit",
        visit4: "4th Visit",
        visit5Up: "5th plus Visit",
        total: "Total",
        numberOfPregnanciesAtRisk: "Number of Pregnancies at Risk",
        caseAnemia: "Case of Anemia in Pregnant Women",
        pWIronFolate: "Pregnant Women Receiving Iron Folate",
        pWIronDef: "Pregnant Women Being Treated for Iron Deficiency Anemia",
        pWBirthPlan: "Pregnant Women with a Birth Plan",
        pWMalaria: "Pregnant Women with Confirmed Malaria treated with Chloroquine",
        pWMosquito: "Pregnant Women Who Received an Impregnated Mosquito Net",
        pWMuac: "Pregnant women MUAC<210mm",
        wIronFolate: "Other Women Receiving Iron Folate",
        wAceticAcid: "Women Receiving Acetic Acid Inspection",
        wSmearTest: "Positive Women After Smear Test",
        wSmearTakenCare: "Women Positive Smear Test taken Care of",
        wPostabortion: "Women Receiving Postabortion Care",
        ageOfMothers: "Age of Mothers",
        years15: "<15 Years",
        years15_19: "15-19 Years",
        years20_24: "20-24 Years",
        years25_29: "25-29 Years",
        years30Up: "30 Years Plus",
        unknown: "Unknown",
        labourManagement: "Labor Management",
        useOfPartograph: "Use of partograph",
        managementLabour3rdYear: "Active Management of the 3rd Phase of Labour",
        hospitalisedNICU: "Hospitalized NICU",
        hospitalisedPAED: "Hospitalized PAED",
        ofTotalDischargedNICU: "Of total discharged number: NICU discharged",
        diedNICUBefore48h: "Died in the NICU before 48h",
        diedPAEDBefore48h: "Died in the PAED before 48h",
        diedNICUAfter48h: "Died in the NICU after 48h",
        diedPAEDAfter48h: "Died in the PAED after 48h",
        reasonSelfDischarge: "Reason for self-discharge",
        financeCare: "Finance: Leave as cannot afford care",
        financeAvoidPay: "Finance: Left to avoid paying",
        religiousCultural: "Religious / Cultural",
        personalFamily: "Personal / Family",
        other: "Other",
        wherePatientsComeFrom: "Where do patients come from?",
        quMo: "Quarter Morin",
        capHai: "Cap Haitian",
        deptNord: "Department Nord",
        otherDept: "Other Departments: ",
        ageOfInfant: "Age of infant admitted",
        extremePreterm: "Extremely preterm (less than 28 weeks)",
        veryPreterm: "Very preterm (28 to 32 weeks)",
        modToLatePreterm: "Moderate to late preterm (32 to 37 weeks)",
        fullTerm: "Full term (37 weeks plus)",
        olderThanNeonate: "Older than neonate (>4 weeks old)",
        age4w_5y: "Age 4 weeks - 5 years",
        age6_11: "Age 6-11 years",
        age12_18: "Age 12-18 years",
        gender: "Gender",
        male: "Male",
        female: "Female",
        mainCond: "Main Condition",
        respiratoryArrest: "Respiratory arrest",
        traumaticInjury: "Traumatic injury",
        septicShock: "Septic shock",
        hypoShock: "Hypovolemic shock",
        seizureConvulsion: "Seizures/Convulsions",
        poisoning: "Poisoning",
        altMentalStatus: "Altered mental status",
        gastro: "Gastroenteritis",
        hemorrhage: "Hemorrhage",
        hypothermia: "Hypothermia",
        cardiacAnomaly: "Cardiac congenital anomaly",
        otherAnomaly: "Other congenital anomaly",
        malnutrition: "Malnutrition",
        meningitis: "Meningitis",
        communityPneum: "Community acquired pneumonia",
        aspirationPneum: "Aspiration pneumonia",
        modPrematurity: "Moderate prematurity (32-36 weeks gestation)",
        severePrematurity: "Severe prematurity (less than 32 weeks)",
        otherMedical: "Other medical: ",
        numberOfOutPatients: "Number of outpatients",
        age: "Age",
        boy: "Boy",
        girl: "Girl",
        birthControl: "Birth control",
        methodsF: "Methods/Sex for women",
        methodsM: "Methods/Sex for men",
        ocp: "OCP?",
        patch: "Patch?",
        depoInjection: "Depo injection",
        implant: "Implant",
        IUD: "Inter uterine devices (IUD)",
        vaginalRing: "Vaginal ring",
        bfAsBirthControl: "Breastfeeding as birth control",
        femaleCondom: "Female condom",
        sterilisation: "Sterilisation",
        maleCondom: "Male condom",
        vasectomy: "Vasectomy",
        sterilisationAmount: "Number of sterilizations",
        vasectomyAmount: "Number of vasectomies",
        accepting: "Accepting",
        totalUsers: "Total users",
        years25: "<25 years",
        years25Up: "25 years and older",
        contraceptivesDist: "Contraceptives distributed",
        quantity: "Quantity",
        daysOutStock: "# of days out of stock / month",
        ocpCycle: "OCP Cycles",
        patchCycle: "Patch Cycles",
        depoInjectionVial: "Depo injection Cycles",
        implantPacket: "Implant Packets",
        IUDPiece: "Inter uterine devices (IUD) Pieces",
        vaginalRingPiece: "Vaginal ring Pieces",
        femaleCondomPiece: "Female condom Pieces",
        maleCondomPiece: "Male condom Pieces",
      },
      departmentPage: {
        nicupaed: "NICU/PAED",
        maternity: "Maternity",
        rehab: "Rehab",
        communityHealth: "Community Health",
        caseStudy: "Case Study",
        dueDate: "Due Date: ",
        dataInput: "Data Input",
        employeeOfTheMonth: "Employee Of The Month",
        someWords: "Some words..",
        biomechSupport: "Biomechanic Support",
        departmentPoints: "Department Points",
        monthly: "Monthly: ",
        annually: "Annually: ",
      },
      leaderBoard: {
        leadersBoard: "Leaders Board",
        monthlyAward: "Monthly Award",
        annualAward: "Annual Award",
        position: "Position",
        department: "Department",
        points: "Points",
        caseStudyOTM: "Case Study of the Month",
      },
      dataInput: {
        awards: "Awards",
        monthly: "Monthly",
        annual: "Annual",
        submit: "Submit",
      },
      caseStudyForm: {
        caseStudyForm: "Case Study Entry Form",
        selectCSType: "Select A Case Study Type: ",
        pStory: "Patient Story",
        pName: "Patient's Name",
        pAge: "Patient's Age",
        pFrom: "Where is the patient from?",
        pChoose: "Why did the patient choose to come to HCBH?",
        pHowLongHCBH: "How long were they at HCBH?",
        diagnosis: "What was their diagnosis?",
        morePersonalElements: "Add more personal elements to the story, quote from the patient/family member, etc.",
        sRecognition: "Staff Recognition",
        sName: "Staff Name",
        roleJob: "Role/Job Title",
        whatDept: "What department does this staff member work in?",
        sHowLongHCBH: "How long have they been working at HCBH?",
        enjoyHCBH: "What do they enjoy most about working at HCBH?",
        sRecognise: "Why is this person being recognized? Act of kindness? Anniversary? etc.",
        tSession: "Training Session",
        tDate: "Training Date",
        tAbout: "What was the training on?",
        tConducted: "Who conducted the training?",
        tAttend: "Who attended the training?",
        tBenefit: "How will the training benefit HCBH and its staff?",
        generalSummary: "Include a general summary of the training, its success, etc.",
        eReceived: "Equipment Received",
        eWhat: "What equipment was received?",
        eDept: "What department received the equipment?",
        eFrom: "Who was the equipment from?",
        eDonatePurchase: "Was the equipment donated or purchased?",
        eDo: "What does this new equipment do?",
        eBenefit: "Include who will benefit from this equipment, what value it adds to HCBH, etc.",
        other: "Other",
        eExtra: "Include anything that does not fit into any of the categories.",
        disclaimer: "This person has given permission to share their story and photo in HHA communications, including online platforms.",
        addPhoto: "Add a photo: ",
        submit: "Submit",
      },
    },
  },
})

export default i18n