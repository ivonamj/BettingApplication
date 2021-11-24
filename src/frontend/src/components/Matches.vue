<template>
  <div class="submit-form">
    <div class="form-group">
      <table class="table table-striped">
        <thead>
          <th></th>
          <th>1</th>
          <th>2</th>
          <th>X</th>
        </thead>
        <tbody>
          <tr v-for = "(match, index) in matches" v-bind:key = "match.id">
            <td> {{match.name}} </td>
            <td><input type="radio" value="1" :name=index @change="onChange($event)">{{match.home_win}}</td>
            <td><input type="radio" value="2" :name=index @change="onChange($event)">{{match.away_win}}</td>
            <td><input type="radio" value="X" :name=index @change="onChange($event)">{{match.draw}}</td>
          </tr>
        </tbody>
      </table>
    </div>
    <h1 class="form-group">
      <input
          class="form-control"
          id="payment"
          required
          v-model="betslip.payment"
          name="payment"/>
      <h6 v-if="betslip.payment <= 0.0 || betslip.payment ==  null || somethingAdded == false">
        The payment must be greater than 0 and it must be checked at least one match!</h6>
      <button v-else @click="AddBetslip" class="btn btn-success">Add</button>
    </h1>
  </div>
</template>

<script>
import BettingService from "@/services/BettingService";

  export default {
    name: 'Matches',
    data(){
      return {
        matches: [],
        betslip: {
          id: null,
          placedBetslip: "0000000000",
          payment: null,
          odds: null,
          possibleGain: null
        },
        somethingAdded: false
      }
    },
    methods: {
      GetMatches() {
        BettingService.GetMatches().then((response) => {
          this.matches = response.data;
        });
      },
      onChange(event) {
        this.somethingAdded = true;
        var win = event.target.value;
        var index = event.target.name;
        String.prototype.replaceAt = function(index, win) {
          var chars = this.split('');
          chars[index] = win;
          return chars.join('');
        }
        this.betslip.placedBetslip = this.betslip.placedBetslip.replaceAt(index, win);
      },
      AddBetslip() {
        var data = {
          somethingAdded: false,
          payment: this.betslip.payment,
          placedBetslip: this.betslip.placedBetslip
        };
        BettingService.AddBetslip(data).then(response => {
          this.betslip.id = response.data.id;
        })
      }
    },
    created() {
      this.GetMatches()
      this.AddBetslip()
    }
  }
</script>