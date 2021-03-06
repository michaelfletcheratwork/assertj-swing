package org.assertj.swing.driver;

import static org.assertj.core.util.Preconditions.checkNotNull;
import static org.assertj.swing.edt.GuiActionRunner.execute;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.swing.JTree;
import javax.swing.tree.TreePath;

import org.assertj.swing.annotation.RunsInEDT;
import org.assertj.swing.edt.GuiQuery;

/**
 * Returns how many children a node in a {@code JTree} has. This query is executed in the event dispatch thread (EDT.)
 * 
 * @author Alex Ruiz
 */
final class JTreeChildOfPathCountQuery {
  @RunsInEDT
  static int childCount(final @Nonnull JTree tree, final @Nonnull TreePath path) {
    Integer result = execute(new GuiQuery<Integer>() {
      @Override
      protected @Nullable Integer executeInEDT() {
        Object lastPathComponent = path.getLastPathComponent();
        return tree.getModel().getChildCount(lastPathComponent);
      }
    });
    return checkNotNull(result);
  }

  private JTreeChildOfPathCountQuery() {
  }
}