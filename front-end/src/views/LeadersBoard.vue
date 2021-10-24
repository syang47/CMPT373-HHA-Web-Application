<!-- specify a table with a row describing the title of each column -->
<template>
    <div class = "background">
        <table>
            <tr>
                <th>
                    Pos
                </th>
                <th>
                    Department
                </th>
                <th>
                    Points
                </th>
            </tr>
        </table>
    </div>
</template>

<style scoped>
    .background {
        background: url('../assets/project_photos/leaders_board_background.jpeg') no-repeat;
        /* filter:"progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='scale')"; */
        /* -moz-background-size:100% 100%; */
        position: relative;
        /* background-size: 100% 100%; */
        height: 100%;
        position: relative;
        background-position: center;
        background-repeat: no-repeat;
        background-size:cover;
    }

@import url('https://fonts.googleapis.com/css?family=Rubik:300,400,500');

* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}
body {
  border-top: 4px solid #DC0000;
  background: #15151E;
  color: #fff;
  font-family: 'Rubik', sans-serif;
  /* center the table horizontally */
  display: flex;
  flex-direction: column;
  align-items: center;
}

table {
  width: calc(90vw - 2rem);
  max-width: 3000px;
  border-spacing: 0 1rem;
}

table tr > * {
  text-align: center;
  padding: 0.5rem;
}

table tr > *:nth-child(2) {
  text-align: left;
}

table th {
  font-weight: 300;
  letter-spacing: 0.04rem;
  font-size: 0.9rem;
  color: #eee;
}

table td.gap span {
  background: #38383F;
  border-radius: 30px;
  padding: 0.5rem 0.75rem;
  font-size: 0.8rem;
  text-transform: uppercase;
}

@media (max-width: 500px) {
  table tr > *:nth-child(3) {
    display: none;
  }
}
</style>