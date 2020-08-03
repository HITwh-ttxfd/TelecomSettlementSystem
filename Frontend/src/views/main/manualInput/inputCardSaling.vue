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
                  v-for="item in options"
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
                  v-for="item in options"
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
      <el-table border style="width: 100%;" max-height="300" :data="tableData">
        <el-table-column type="selection" width="55" header-align="center" align="center"/>
        <el-table-column label="序号" prop="index" width="60" header-align="center" align="center"/>
        <el-table-column label="城市" prop="city" header-align="center" align="center"/>
        <el-table-column label="产品" prop="product" header-align="center" align="center"/>
        <el-table-column label="卡销售数量" prop="outType" header-align="center" align="center"/>
        <el-table-column label="面值金额" prop="inMonth" header-align="center" align="center"/>
        <el-table-column label="卡总金额" prop="inMoney" header-align="center" align="center"/>
        <el-table-column label="折扣后金额" prop="inMoney" header-align="center" align="center"/>
        <el-table-column label="稽核" prop="inPerson" header-align="center" align="center"/>
        <el-table-column label="录入人" prop="inPerson" header-align="center" align="center"/>
        <el-table-column label="操作" width="120" header-align="center" align="center">
          <el-button type="primary" icon="el-icon-edit" @click="editRecord" circle></el-button>
          <el-button type="danger" icon="el-icon-delete" @click="delRecord" circle></el-button>
        </el-table-column>
      </el-table>
    </el-card>
  </div>
</template>

<script>
  import XLSX from "xlsx";

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
        options: [{
          value: '000',
          label: '江西本部'
        }, {
          value: '选项2',
          label: '江西景德镇'
        }, {
          value: '选项3',
          label: '江西南昌'
        }, {
          value: '选项4',
          label: '江西吉安'
        }, {
          value: '选项5',
          label: '北京烤鸭'
        }],
        value: ''
      }
    },
    methods: {
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
        //  从xls导入
      },
      editRecord(){
        //  修改记录
      },
      delRecord(){
        //  删除记录
      }
    },
  }
</script>

<style scoped>

</style>
