<style scoped>
    .sidemenu{
        padding-top: 150px;
    }
    .container-fluid {height:inherit;}
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
        ref="sidebar"
        v-if="showSideBar"
        class="sidemenu"
        :collapsed="collapsed" 
        :menu="menu"
        :show-one-child="true"
        @toggle-collapse="onToggleCollapse"
        @itemClick="onItemClick">
    </sidebar-menu>
    <div v-if="isOnMobile && !collapsed" class="sidebar-overlay" @click="collapsed=true" />
    
</template>

<script lang="ts" type="text/typescript">
import { defineComponent } from 'vue';
import { createPopper } from '@popperjs/core';
const separator = {
  template: `<hr style="border-color: rgba(0,0,0,0.1); margin: 20px;">`
}
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
                    component: separator
                },
                {
                    title: 'Home',
                    href: '/Home_fe',
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
            showSideBar: false,

        }
    },
    mounted() {
        let token = JSON.parse(localStorage.getItem('user')!);
        if(token != null) {
            this.showSideBar = true;
        } else {
            this.showSideBar = false;
        }
        const dropdownUser = document.querySelector('#dropdown');

    },
    methods: {
        onToggleCollapse(collapsed): void {
            this.collapsed=collapsed;
        },
        onItemClick(event, item, node): void {
            console.log(item);
        },
        onResize(): void {
            if(window.innerWidth <= 767) {
                this.isOnMobile = true
                this.collapsed = true
            } else {
                this.isOnMobile = false
                this.collapsed = false
            }
        },
        
    }
});

</script>