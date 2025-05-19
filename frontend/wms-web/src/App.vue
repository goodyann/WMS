<template>
  <div id="app">
    <index-page></index-page>
  </div>
</template>

<script>
import IndexPage from './components/IndexPage.vue';


export default {
  name: 'App',
  components: {
    IndexPage
  }
}
</script>

<style>
#app {
  height: 100%;
}
</style>
