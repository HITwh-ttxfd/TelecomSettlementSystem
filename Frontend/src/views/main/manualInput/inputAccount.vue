<template>
  <div>
    <!--面包屑导航区-->
    <el-breadcrumb separator-class="el-icon-arrow-right" style="padding-bottom: 20px">
      <el-breadcrumb-item :to="{ path: '/main' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>手工收入录入</el-breadcrumb-item>
      <el-breadcrumb-item>出账收入录入</el-breadcrumb-item>
    </el-breadcrumb>
    <el-card>
      <!--查询表单-->
      <el-form ref="form" :model="form" label-width="80px">
        <el-row>
          <el-col :span="11">
            <el-form-item label="城市">
              <el-select style="width: 100%" v-model="form.inCity" filterable placeholder="请选择">
                <el-option
                  v-for="item in optionsCity"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="11">
            <el-form-item label="产品">
              <el-select style="width: 100%" v-model="form.inPro" filterable placeholder="请选择">
                <el-option
                  v-for="item in optionsPro"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="11">
            <el-form-item label="出账类型">
              <el-select style="width: 100%" v-model="form.inType" filterable placeholder="请选择">
                <el-option
                  v-for="item in optionsOut"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="11">
            <el-form-item label="录入金额">
              <el-input v-model="form.inMoney" placeholder="请输入金额"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <!--按钮区域-->
        <el-form-item>
          <el-col style="display: flex; justify-content: left;">
            <el-button @click="search">查询</el-button>
            <el-button @click="input">录入</el-button>
            <el-button @click="common.exportXLS('出账收入表', tableData)">导出</el-button>
            <el-button @click="inputXLS">导入</el-button>
            <el-button @click="batchDel">批量删除</el-button>
          </el-col>
        </el-form-item>
        <!--按钮区域结束-->
      </el-form>
      <!--查询表单结束-->
      <!--显示表格-->
      <el-table border style="width: 100%;" max-height="300" :data="tableData">
        <el-table-column type="selection" width="55" header-align="center" align="center"/>
        <el-table-column label="序号" prop="index" width="70" header-align="center" align="center"/>
        <el-table-column label="城市" prop="city" width="90" header-align="center" align="center"/>
        <el-table-column label="产品" prop="product" width="90" header-align="center" align="center"/>
        <el-table-column label="出账类型" prop="outType" width="100" header-align="center" align="center"/>
        <el-table-column label="录入月份" prop="inMonth" header-align="center" align="center"/>
        <el-table-column label="录入金额" prop="inMoney" header-align="center" align="center"/>
        <el-table-column label="稽核" prop="inPerson" header-align="center" align="center"/>
        <el-table-column label="录入人" prop="inPerson" width="90" header-align="center" align="center"/>
        <el-table-column label="操作" header-align="center" align="center">
          <el-button :disabled="check" type="primary" icon="el-icon-edit" @click="editRecord" circle></el-button>
          <el-button :disabled="check" type="danger" icon="el-icon-delete" @click="delRecord" circle></el-button>
        </el-table-column>
      </el-table>
    </el-card>
  </div>
</template>

<script>
  import XLSX from 'xlsx'
  export default {
    name: "inputAccount",
    data() {
      return {
        form: {
          inCity: '',   // 城市编码
          inPro: '',    // 产品编码
          inType: '',   // 出账类型
          inMoney: '',  // 录入金额
          inDate: '',   // 录入时间
          inPerson: '', // 录入人
        },
        tableData: [
          {
            index: 1,
            city: '哈尔滨',
            product: '产品A',
            outType: '已出账',
            inMonth: '录入月份',
            inMoney: '录入金额',
            inPerson: '张三',
          },
          {
            index: 1,
            city: '哈尔滨',
            product: '产品A',
            outType: '已出账',
            inMonth: '录入月份',
            inMoney: '录入金额',
            inPerson: '张三',
          },
          {
            index: 1,
            city: '哈尔滨',
            product: '产品A',
            outType: '已出账',
            inMonth: '录入月份',
            inMoney: '录入金额',
            inPerson: '张三',
          },
          {
            index: 1,
            city: '哈尔滨',
            product: '产品A',
            outType: '已出账',
            inMonth: '录入月份',
            inMoney: '录入金额',
            inPerson: '张三',
          }
        ],
        check: false,
        optionsPro: [],
        optionsCity: [],
        optionsOut: [],
      }
    },
    methods:{
      search(){
        //  查询函数
      },
      input(){
        //  录入函数
      },
      batchDel(){
        //  批量删除
      },
      inputXLS(){
        //  导入xls
      },
      editRecord(){
        //  修改记录
      },
      delRecord(){
        //  删除记录
      },
      loadInfo(){
        //  加载信息
        //  加载产品信息
        this.$axios.get('http://localhost:8080/RpProductCodeTController/selectRpProductCodeT').then(res=>{
          var tmp = new Array(res.data.length)
          for(var i in res.data){
            tmp[i] = {}
            tmp[i].value = res.data.productCode
            tmp[i].label = res.data.productName
          }
          this.optionsPro = tmp
        })
        //  加载城市信息
        this.$axios.get('http://localhost:8080/RpCityCodeT/selectRpCityCodeT').then(res=>{
          var tmp = new Array(res.data.length)
          for(var i in res.data){
            tmp[i] = {}
            tmp[i].value = res.data.cityName
            tmp[i].label = res.data.cityCode
          }
          this.optionsCity = tmp
        })
        //  加载出账类型信息
        this.$axios.get().then(res=>{
          var tmp = new Array(res.data.length)
          for(var i in res.data){
            tmp[i] = {}
            tmp[i].value = res.data
            tmp[i].label = res.data
          }
          this.optionsOut = tmp
        })
      }
    },
    mounted() {

    }
  }
</script>

<style scoped>


</style>
