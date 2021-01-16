<template>
  <v-navigation-drawer color="primary" dark app permanent>
      <v-list
        dense
        nav
      >
        <v-list-item
          v-for="item in items"
          :key="item.title"
          :to="item.link"
          link
          exact
        >
          <v-list-item-icon>
            <v-icon>{{ item.icon }}</v-icon>
          </v-list-item-icon>

          <v-list-item-content>
            <v-list-item-title>{{ item.title }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
</template>

<script>
export default {
  name:'SideBar',
  data: () => ({
    items: [
      { title: 'Products Management', icon: 'mdi-home', link: { name: 'About' } },
      { title: 'Clients Management', icon: 'mdi-chart-bar', link: { name: 'Home' } },
      { title: 'Sales', icon: 'mdi-chat'  },
    ],
  }),
}
</script>