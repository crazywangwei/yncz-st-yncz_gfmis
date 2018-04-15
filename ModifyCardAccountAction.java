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
 * ���񿨻����˻��޸Ĳ���
 * @author lgq
 * 2016-09-30
 *
 */
public class ModifyCardAccountAction extends CommonAction {


	/**
	 * ���а汾��ʶId
	 */
	private static final long serialVersionUID = -8969514782976869166L;
	/**
	 * ���캯��
	 */
	public ModifyCardAccountAction() {
		super();
	}
	
	/**
	 * ���������캯��
	 */
	public ModifyCardAccountAction(DisplayPanel panel) {
		super(panel);
	}
	
	public void realActionPerform(ActionEvent e) {
		try {
			List list = this.getPanel().getOperationTable()[0].getSelectedData();
			if(null == list || list.size() == 0 ) {
				PlatformTools.showFailDialog("��ѡ����Ҫ�޸ĵ�����!");
				return;
			}
			if(list.size() > 1 ) {
				PlatformTools.showFailDialog("�빴ѡ�������ݽ��в���!");
				return;
			}
			new CardAccountManagerDialog(Global.mainFrame,this.getPanel(),"modify",(XMLData)list.get(0));
		} catch (Exception e2) {
			throw new ViewException("��ʼ��¼��������");
		}
	}

}
