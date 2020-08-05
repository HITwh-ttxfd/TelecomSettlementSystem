<template>
  <div>
    <!--面包屑导航区-->
    <el-breadcrumb separator-class="el-icon-arrow-right" style="padding-bottom: 20px">
      <el-breadcrumb-item :to="{ path: '/main' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>手工收入录入</el-breadcrumb-item>
      <el-breadcrumb-item>卡销售收入录入</el-breadcrumb-item>
    </el-breadcrumb>
    <el-card>
      <!--查询表单-->
      <el-form ref="form" :model="form" label-width="90px">
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
            <el-form-item label="产品" label-width="100px">
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
            <el-form-item label="卡销售数量">
              <el-input v-model="form.inNum" placeholder="请输入数量"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="11">
            <el-form-item label="面值金额" label-width="100px">
              <el-input v-model="form.inCardMoney" placeholder="请输入金额"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="11">
            <el-form-item label="卡总金额">
              <el-input v-model="form.inTotal" placeholder="计算得出"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="11">
            <el-form-item label="折扣后总金额" label-width="100px">
              <el-input v-model="form.inDiscount" placeholder="请输入折扣后总金额"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <!--按钮区域-->
        <el-form-item>
          <el-col style="display: flex; justify-content: left;">
            <el-button @click="search">查询</el-button>
            <el-button @click="reload">重置</el-button>
            <el-button @click="input">录入</el-button>
            <el-button @click="common.exportXLS('卡销售收入表', tableData)">导出</el-button>
            <el-button @click="inputXLS">导入</el-button>
            <el-button @click="batchDel">批量删除</el-button>
          </el-col>
        </el-form-item>
        <!--按钮区域结束-->
      </el-form>
      <!--查询表单结束-->
      <!--显示表格-->
      <el-table border style="width: 100%;" max-height="270" :data="tableData"
                @selection-change="handleSelectionChange">
        <el-table-column type="selection" :selectable="selectJudge" width="55" header-align="center" align="center"/>
        <el-table-column label="序号" prop="id" width="60" header-align="center" align="center"/>
        <el-table-column label="城市" prop="cityCode" header-align="center" align="center"/>
        <el-table-column label="产品" prop="productCode" width="130" header-align="center" align="center"/>
        <el-table-column label="卡销售数量" prop="cardSaleAmount" header-align="center" align="center"/>
        <el-table-column label="面值金额" prop="cardParValueFee" header-align="center" align="center"/>
        <el-table-column label="卡总金额" prop="totalFee" header-align="center" align="center"/>
        <el-table-column label="折扣后金额" prop="discountFee" header-align="center" align="center"/>
        <el-table-column label="稽核" prop="checkStatus" header-align="center" align="center"/>
        <el-table-column label="录入人" prop="recordOperator" header-align="center" align="center"/>
        <el-table-column label="操作" width="120" header-align="center" align="center">
          <template slot-scope="scope">
            <el-button :disabled="scope.row.checkStatus==='已通过'?true:false" type="primary" icon="el-icon-edit"
                       @click="editRecord(scope.row)" circle></el-button>
            <el-button :disabled="scope.row.checkStatus==='已通过'?true:false" type="danger" icon="el-icon-delete"
                       @click="delRecord(scope.row)" circle></el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-card>
    <!--修改弹窗-->
    <el-dialog
      :title="logTitle"
      :visible.sync="centerDialogVisible"
      width="50%"
      center>
      <el-form ref="form" :model="form" label-width="100px">
        <el-row>
          <el-col :span="11">
            <el-form-item label="城市">
              <el-select style="width: 100%" v-model="editIndex.cityCode" filterable placeholder="请选择">
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
              <el-select style="width: 100%" v-model="editIndex.productCode" filterable placeholder="请选择">
                <el-option
                  v-for="item in optionsPro"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="11">
            <el-form-item label="卡销售数量">
              <el-input v-model="editIndex.cardSaleAmount" placeholder="请输入数量"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="11">
            <el-form-item label="面值金额" label-width="100px">
              <el-input v-model="editIndex.cardParValueFee" placeholder="请输入金额"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="11">
            <el-form-item label="卡总金额">
              <el-input v-model="editIndex.totalFee" placeholder="计算得出"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="11">
            <el-form-item label="折扣后总金额" label-width="100px">
              <el-input v-model="editIndex.discountFee" placeholder="请输入折扣后总金额"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="11">
            <el-form-item label="录入月份">
              <el-date-picker v-model="editIndex.saleDate" value-format="yyyy-MM-dd"
                              type="date" style="width: 100%" placeholder="选择日期">
              </el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="11">
            <el-form-item label="序号">
              <el-input :disabled="check" v-model="editIndex.id" placeholder="请输入序号"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="11">
            <el-form-item label="录入人">
              <el-input :disabled="check" v-model="editIndex.recordOperator" placeholder="请输入录入人"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="11">
            <el-form-item label="稽核">
              <el-input :disabled="check" v-model="editIndex.checkStatus" placeholder="请输入稽核状态"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <span slot="footer" class="dialog-footer">
    <el-button @click="centerDialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="confirmEdit">确 定</el-button>
  </span>
    </el-dialog>
  </div>
</template>

<script>
  export default {
    name: "inputCardSaling",
    data() {
      return {
        form: {
          inCity: '',         // 城市编码
          inPro: '',          // 产品编码
          inNum: '',          // 卡销售数量
          inCardMoney: '',    // 面值金额
          inTotal: '',        // 卡总金额
          inDiscount: ''      // 折扣后总金额
        },
        tableData: [],
        optionsPro: [],
        optionsCity: [],
        value: '',
        delList: [],
        logTitle: '',
        centerDialogVisible: false,
        check: false,
        editIndex: {},
      }
    },
    methods: {
      search() {
        //  查询函数
        this.check = false
        this.editIndex = {}
        this.logTitle = '查询记录'
        this.centerDialogVisible = true
      },
      input() {
        //  录入函数
        var data = this.form
        // data.inDate = this.common.getNowTime().substring(0, 10)
        data.inDate = this.common.getNowTime()
        // console.log(data)
        for (var i in data) {
          if (data[i] === '') {
            this.$message.error('请将录入项都补充完整')
            return
          }
        }
        this.$axios.get('http://localhost:8080/RpCardSaleRecordT/createRpCardSaleRecordT/?' +
          'cityCode=' + data.inCity + '&productCode=' + data.inPro + '&saleDate=' + data.inDate +
          '&discountRate=' + (parseFloat(data.inDiscount) / parseFloat(data.inTotal).toFixed(2)) +
          '&cardSaleAmount=' + data.inNum + '&cardParValueFee=' + data.inCardMoney +
          '&recordOperator=' + data.inPerson + '&totalFee=' + data.inTotal + '&discountFee=' + data.inDiscount).then(res => {
          this.$message.success('录入记录成功！')
          this.reload()
        })
      },
      batchDel() {
        //  批量删除
        if (this.delList.length === 0) {
          this.$message.warning('请选择要删除的记录.')
          return
        }
        var url = 'http://localhost:8080/RpCardSaleRecordT/deleteRpCardSaleRecordT/?ids='
        for (var i in this.delList) {
          url = url + this.delList[i].id
          if (i < (this.delList.length - 1)) {
            url = url + ','
          }
        }
        this.$axios.get(url).then(res => {
          this.$message.success('删除记录成功！')
          this.delList = []
          this.reload()
        })
      },
      inputXLS() {
        //  从xls导入
      },
      editRecord(row) {
        //  修改记录
        this.logTitle = '修改记录'
        this.editIndex = row
        this.check = true
        this.centerDialogVisible = true
      },
      delRecord(row) {
        //  删除记录
        this.$axios.get('http://localhost:8080/RpCardSaleRecordT/deleteRpCardSaleRecordT/?ids=' + row.id)
          .then(res => {
            this.$message.success('删除记录成功！')
            this.loadTable()
          })
      },
      handleSelectionChange(val) {
        //  选中表格事件 val表示选中的元组数组
        this.delList = val
      },
      selectJudge(row, index) {
        //  可选择判断
        if (row.checkStatus === '已通过')
          return false
        else
          return true
      },
      loadInfo() {
        //  加载信息
        //  加载产品信息
        this.$axios.get('http://localhost:8080/RpProductCodeTController/selectRpProductCodeT').then(res => {
          var tmp = new Array(res.data.length)
          for (var i in res.data) {
            tmp[i] = {}
            tmp[i].value = res.data[i].productCode
            tmp[i].label = res.data[i].productName
          }
          this.optionsPro = tmp
        })
        //  加载城市信息
        this.$axios.get('http://localhost:8080/RpCityCodeT/selectRpCityCodeT').then(res => {
          var tmp = new Array(res.data.length)
          for (var i in res.data) {
            tmp[i] = {}
            tmp[i].value = res.data[i].cityName
            tmp[i].label = res.data[i].cityCode
          }
          this.optionsCity = tmp
        })
        //  加载用户名
        this.$axios.get('http://localhost:8080/RpUserT/getRpUserT?userID=' + sessionStorage.getItem('user'))
          .then(res => {
            this.form.inPerson = res.data.userName
          })
      },
      reload() {
        //  重置页面
        this.form.inCity = ''
        this.form.inPro = ''
        this.form.inNum = ''
        this.form.inCardMoney = ''
        this.form.inTotal = ''
        this.form.inDiscount = ''
        this.loadInfo()
        this.loadTable()
      },
      loadTable() {
        //  加载表格数据
        this.$axios.get('http://localhost:8080/RpCardSaleRecordT/getAllRpCardSaleRecordT').then(res => {
          this.tableData = res.data
          // console.log(res.data)
        })
      },
      confirmEdit() {
        //  弹窗提交
        if (this.check) {
          //  修改记录
          //  修改为编码
          /*for (var i in this.editIndex) {
            if (this.editIndex[i] === null && i !== 'checkPerson') {
              this.$message.error('不能修改记录属性为空值！')
              return
            }
            if (this.editIndex[i] === null &&  i !== 'checkTime') {
              this.$message.error('不能修改记录属性为空值！')
              return
            }
          }*/
          for (var i in this.optionsCity) {
            if (this.editIndex.cityCode === this.optionsCity[i].label) {
              this.editIndex.cityCode = this.optionsCity[i].value
              break
            }
          }
          for (var i in this.optionsPro) {
            if (this.editIndex.productCode === this.optionsPro[i].label) {
              this.editIndex.productCode = this.optionsPro[i].value
              break
            }
          }
          console.log(this.editIndex)
          this.$axios.get('http://localhost:8080/RpCardSaleRecordT/changeRpCardSaleRecordT/?' +
            'ID=' + this.editIndex.id + '&cityCode=' + this.editIndex.cityCode + '&productCode=' + this.editIndex.productCode +
            '&saleDate=' + this.editIndex.saleDate + '&discountRate=' + this.editIndex.discountRate +
            '&cardSaleAmount=' + this.editIndex.cardSaleAmount + '&cardParValueFee=' + this.editIndex.cardParValueFee +
            '&checkStatus=' + this.editIndex.checkStatus + '&totalFee=' + this.editIndex.totalFee +
            '&discountFee=' + this.editIndex.discountFee).then(res => {
            this.$message.success('修改记录成功！')
            this.reload()
          })
        } else {
          //  查询记录
          var url = 'http://localhost:8080/RpCardSaleRecordT/selectAllRpCardSaleRecordT/?'
          for (var i in this.editIndex) {
            if (i === 'id') {
              url = url + 'ID' + '=' + this.editIndex[i] + '&'
            } else {
              url = url + i + '=' + this.editIndex[i] + '&'
            }
          }
          url = url.substring(0, url.length - 1)
          this.$axios.get(url).then(res => {
            if (res.data.length === 0) {
              this.$message.warning('未查询到符合条件的记录.')
              this.reload()
            } else {
              this.$message.success('查询记录成功！')
              this.tableData = res.data
            }
          })
        }
        this.centerDialogVisible = false
      }
    },
    mounted() {
      this.loadInfo()
      this.loadTable()
    },
  }
</script>

<style scoped>

</style>
