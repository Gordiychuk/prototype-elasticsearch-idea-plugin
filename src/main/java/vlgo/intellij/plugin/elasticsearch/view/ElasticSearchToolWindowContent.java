package vlgo.intellij.plugin.elasticsearch.view;


import com.intellij.ide.util.treeView.NodeRenderer;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.ActionToolbar;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.actionSystem.Separator;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.SimpleToolWindowPanel;
import com.intellij.ui.ScrollPaneFactory;
import com.intellij.ui.TreeSpeedSearch;
import com.intellij.ui.components.JBScrollPane;
import com.intellij.ui.treeStructure.Tree;
import com.intellij.util.containers.Convertor;
import com.intellij.util.ui.tree.TreeUtil;
import vlgo.intellij.plugin.elasticsearch.ElasticSearchSetting;
import vlgo.intellij.plugin.elasticsearch.ElasticsearchServersSetting;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;
import java.util.Collection;
import java.util.List;

public class ElasticSearchToolWindowContent extends SimpleToolWindowPanel {
    private static final String PLACE_TOOLBAR = "ElasticSearchServersToolWindowContent#Toolbar";
    private static final String SERVERS_TOOL_WINDOW_TOOLBAR = "ElasticSearchServersViewToolbar";

    private DefaultTreeModel myTreeModel;
    private Tree myTree;
    private Tree mongoTree;
    private final Project project;

    public ElasticSearchToolWindowContent(Project project) {
        super(true, true);
        this.project = project;

//        myTreeModel = new DefaultTreeModel(new DefaultMutableTreeNode());
//        myTree = new Tree(myTreeModel);
//        myTree.setRootVisible(false);

//        myTree.setShowsRootHandles(true);
//        myTree.setCellRenderer(new NodeRenderer());
//        myTree.setLineStyleAngled();

//        setContent(ScrollPaneFactory.createScrollPane(this.myTree));


        mongoTree = createTree();
        mongoTree.setCellRenderer(new NodeRenderer());
        mongoTree.setName("mongoTree");


        final DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode();
        mongoTree.setModel(new DefaultTreeModel(rootNode));
        for (int i =10;i<10;i++) {
            DefaultMutableTreeNode serverNode = new DefaultMutableTreeNode("NODE "+i);
//            mongoTree.add(serverNode);
//            DefaultMutableTreeNode serverNode = new DefaultMutableTreeNode(mongoServer);
            rootNode.add(serverNode);
        }

        TreeUtil.expand(mongoTree, 2);

        JBScrollPane mongoTreeScrollPane = new JBScrollPane(mongoTree);
        setContent(mongoTreeScrollPane);
        setToolbar(createToolbar());

//        ApplicationManager.getApplication()
//                .invokeLater(this::reloadAllServerConfigurations);
    }

    private Collection<ElasticSearchSetting> getServerConfigurations() {
        return ElasticsearchServersSetting.getInstance(project).getSettings();
    }

    public void reloadAllServerConfigurations() {
        final DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode();
        mongoTree.setModel(new DefaultTreeModel(rootNode));
        for (int i =10;i<10;i++) {
            DefaultMutableTreeNode serverNode = new DefaultMutableTreeNode("NODE "+i);
//            mongoTree.add(serverNode);
//            DefaultMutableTreeNode serverNode = new DefaultMutableTreeNode(mongoServer);
            rootNode.add(serverNode);
        }

//
//        for (ServerConfiguration serverConfiguration : serverConfigurations) {
//            MongoServer mongoServer = new MongoServer(serverConfiguration);
//            this.mongoManager.registerServer(mongoServer);
//            if (serverConfiguration.isConnectOnIdeStartup()) {
//                this.reloadServerConfiguration(serverNode, false);
//            }
//        }

//        this.mongoManager.cleanUpServers();
//        myTree.setRootVisible(false);
//
//        Collection<ElasticSearchSetting> serverConfigurations = getServerConfigurations();
//        if (serverConfigurations.size() == 0) {
////            myTree.setModel(null);
//            return;
//        }

//        final DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode();
//        myTree.setModel(new DefaultTreeModel(rootNode));

//        for (ElasticSearchSetting setting : serverConfigurations) {
////            MongoServer mongoServer = new MongoServer(serverConfiguration);
////            this.mongoManager.registerServer(mongoServer);
//            DefaultMutableTreeNode serverNode = new DefaultMutableTreeNode("NODE ");
//            myTreeModel.add(serverNode);
//            if (serverConfiguration.isConnectOnIdeStartup()) {
//                this.reloadServerConfiguration(serverNode, false);
//            }
//        }
//
//        new TreeSpeedSearch(mongoTree, new Convertor<TreePath, String>() {
//
//            @Override
//            public String convert(TreePath treePath) {
//                final DefaultMutableTreeNode node = (DefaultMutableTreeNode) treePath.getLastPathComponent();
//                final Object userObject = node.getUserObject();
//                if (userObject instanceof MongoDatabase) {
//                    return ((MongoDatabase) userObject).getName();
//                }
//                if (userObject instanceof MongoCollection) {
//                    return ((MongoCollection) userObject).getName();
//                }
//                return "<empty>";
//            }
//        });
//
//        TreeUtil.expand(mongoTree, 2);
    }


    private JComponent createToolbar() {
        DefaultActionGroup group = new DefaultActionGroup();
        group.add(ActionManager.getInstance().getAction(SERVERS_TOOL_WINDOW_TOOLBAR));
        group.add(new Separator());

        ActionToolbar actionToolBar =
                ActionManager.getInstance()
                        .createActionToolbar(PLACE_TOOLBAR, group, true);

        actionToolBar.setTargetComponent(myTree);
        return actionToolBar.getComponent();
    }

    private Tree createTree() {
        Tree tree = new Tree();
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        return tree;
    }
}
