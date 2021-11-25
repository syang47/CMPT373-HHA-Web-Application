<style scoped>
    .sidebar-overlay {
        position: fixed;
        width:100%;
        height:100%;
        top:150;
        left:0;
        background-color: #000;
        opacity: 0.5;
        z-index:900;
    }
</style>
<template>
    
    <sidebar-menu
        :collapsed="collapsed" 
        :menu="menu"
        :showOneChild="true"
        :showChild="true"
        :relative="true"
        >
    </sidebar-menu>
    
</template>

<script lang="ts" type="text/typescript">
import { defineComponent } from 'vue';
export default defineComponent({
    name: "SideMenu",
    data: function() {
        return {
            menu:[
                {
                    header: "Hope Health Action",
                    hiddenOnCollapse: true
                },
                {
                    href:'/leadersboard',
                    title: this.$t("homePage.leaderBoard"),
                    hiddenOnCollapse: true
                },
                {
                    href:'/announcement',
                    title: this.$t("announcementPage.addAnnouncement"),
                    hiddenOnCollapse: true
                },
                {
                    href:'/dataDisplay',
                    title: "DataDisplay",
                    hiddenOnCollapse: true
                },
                {
                    href:'/message_board',
                    title: this.$t("homePage.messageBoard"),
                    hiddenOnCollapse: true
                },
                {
                    href:'/casestudy',
                    title: this.$t("homePage.caseStudy"),
                    hiddenOnCollapse: true
                },
                {
                    href:'/',
                    title: "Departments",
                    child: [
                        {
                            href:"/maternity",
                            title:  this.$t("homePage.maternity"),
                        },
                        {
                            href:"/rehab",
                            title:  this.$t("homePage.rehab"),
                        },
                        {
                            href:"/community_health",
                            title:  this.$t("homePage.communityHealth"),
                        },
                        {
                            href:"/nicu_paed",
                            title:  this.$t("homePage.nicuPaed"),
                        },
                    ],
                    hiddenOnCollapse: true
                },  
                {
                    href: "/register",
                    title: this.$t("header.register"),
                    hiddenOnCollapse: true
                }      
            ],
            collapsed: false,
            isOnMobile: false,

        }
    },
});

</script>