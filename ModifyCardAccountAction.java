package gov.gfmis.card.accountmanager.action;

import gov.gfmis.card.accountmanager.ui.CardAccountManagerDialog;
import gov.gfmis.fap.util.Global;
import gov.gfmis.fap.util.XMLData;
import gov.gfmis.pay.common.action.CommonAction;
import gov.gfmis.pay.common.exception.ViewException;
import gov.gfmis.pay.common.ui.DisplayPanel;
import gov.gfmis.pay.common.util.PlatformTools;

import java.awt.event.ActionEvent;
import java.util.List;

/**
 * 公务卡还款账户修改操作
 * @author lgq
 * 2016-09-30
 *
 */
public class ModifyCardAccountAction extends CommonAction {


	/**
	 * 串行版本标识Id
	 */
	private static final long serialVersionUID = -8969514782976869166L;
	/**
	 * 构造函数
	 */
	public ModifyCardAccountAction() {
		super();
	}
	
	/**
	 * 带参数构造函数
	 */
	public ModifyCardAccountAction(DisplayPanel panel) {
		super(panel);
	}
	
	public void realActionPerform(ActionEvent e) {
		try {
			List list = this.getPanel().getOperationTable()[0].getSelectedData();
			if(null == list || list.size() == 0 ) {
				PlatformTools.showFailDialog("请选择需要修改的数据!");
				return;
			}
			if(list.size() > 1 ) {
				PlatformTools.showFailDialog("请勾选单条数据进行操作!");
				return;
			}
			new CardAccountManagerDialog(Global.mainFrame,this.getPanel(),"modify",(XMLData)list.get(0));
		} catch (Exception e2) {
			throw new ViewException("初始化录入界面错误");
		}
	}

}
