<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
  export default {
    name: 'App'
  }
</script>

<style lang="scss">
  #app {
    /*font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;*/
    /*margin-top: 60px;*/
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
  }

  a {
    text-decoration: none;
    color: #606266;

    &:hover {
      color: #409eff;
    }
  }
</style>
