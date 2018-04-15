package gov.gfmis.card.accountmanager.action;

import gov.gfmis.card.accountmanager.ui.CardAccountManagerDialog;
import gov.gfmis.fap.util.Global;
import gov.gfmis.pay.common.action.CommonAction;
import gov.gfmis.pay.common.exception.ViewException;
import gov.gfmis.pay.common.ui.DisplayPanel;

import java.awt.event.ActionEvent;

/**
 * 公务卡还款账户新增操作
 * @author lgq
 * 2016-09-30
 *
 */
public class AddCardAccountAction extends CommonAction {

	/**
	 * 串行版本标识Id
	 */
	private static final long serialVersionUID = -639040791784317169L;
	
	/**
	 * 构造函数
	 */
	public AddCardAccountAction() {
		super();
	}
	
	/**
	 * 带参数构造函数
	 */
	public AddCardAccountAction(DisplayPanel panel) {
		super(panel);
	}
	
	public void realActionPerform(ActionEvent e) {
		try {
			new CardAccountManagerDialog(Global.mainFrame,this.getPanel(),"new",null);
		} catch (Exception e2) {
			throw new ViewException("初始化录入界面错误");
		}
	}

}
