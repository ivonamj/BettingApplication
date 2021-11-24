<template>
  <div id="app">
    <nav class="navbar navbar-expand navbar-dark bg-dark">
      <div class="navbar-nav mr-auto">
        <li class="nav-item">
          <router-link to="/matches" class="nav-link">Matches</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/betslip" class="nav-link">Betslips</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/wallet" class="nav-link">Wallet</router-link>
        </li>
      </div>
    </nav>

    <div class="container mt-3">
      <router-view />
    </div>
  </div>
</template>

<script>
export default {
  name: "app"
};
</script>
