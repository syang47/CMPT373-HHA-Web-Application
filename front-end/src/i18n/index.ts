// import { Locales } from "./locales";

// import en from "./en.json";
// import fr from "./fr.json";

// export const messages = {
//     [Locales.EN]: en,
//     [Locales.FR]: fr
// };

// export const defaultLocale = Locales.EN;

import { createI18n } from 'vue-i18n'

const i18n = createI18n({
  locale: 'fr', // set locale
  messages: {
    fr: {
      message: {
        login: 'todo',
      },
    },
    en: {
      message: {
        login: 'login',
      },
    },
  },
})

export default i18n