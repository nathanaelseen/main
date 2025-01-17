package igrad.logic.parser;

import static igrad.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static igrad.logic.parser.CliSyntax.PREFIX_TAG;

import igrad.logic.commands.ModuleEditCommand;
import org.junit.jupiter.api.Test;

public class EditCommandParserTest {

    private static final String TAG_EMPTY = " " + PREFIX_TAG;

    private static final String MESSAGE_INVALID_FORMAT =
            String.format(MESSAGE_INVALID_COMMAND_FORMAT, ModuleEditCommand.MESSAGE_USAGE);

    private EditCommandParser parser = new EditCommandParser();

    @Test
    public void parse_missingParts_failure() {
        // no index specified
        //assertParseFailure(parser, CommandTestUtil.VALID_NAME_AMY, MESSAGE_INVALID_FORMAT);

        // no field specified
        //assertParseFailure(parser, "1", ModuleEditCommand.MESSAGE_NOT_EDITED);

        // no index and no field specified
        //assertParseFailure(parser, "", MESSAGE_INVALID_FORMAT);
    }

    @Test
    public void parse_invalidPreamble_failure() {
        // negative index
        //assertParseFailure(parser, "-5" + CommandTestUtil.NAME_DESC_AMY, MESSAGE_INVALID_FORMAT);

        // zero index
        //assertParseFailure(parser, "0" + CommandTestUtil.NAME_DESC_AMY, MESSAGE_INVALID_FORMAT);

        // invalid arguments being parsed as preamble
        //assertParseFailure(parser, "1 some random string", MESSAGE_INVALID_FORMAT);

        // invalid prefix being parsed as preamble
        //assertParseFailure(parser, "1 i/ string", MESSAGE_INVALID_FORMAT);
    }

    @Test
    public void parse_invalidValue_failure() {
        //assertParseFailure(parser,
        //        "1" + CommandTestUtil.INVALID_NAME_DESC, Name.MESSAGE_CONSTRAINTS); // invalid name
        //assertParseFailure(parser,
        //        "1" + CommandTestUtil.INVALID_PHONE_DESC, Phone.MESSAGE_CONSTRAINTS); // invalid phone
        //assertParseFailure(parser,
        //        "1" + CommandTestUtil.INVALID_EMAIL_DESC, Email.MESSAGE_CONSTRAINTS); // invalid email
        //assertParseFailure(parser,
        //        "1" + CommandTestUtil.INVALID_TAG_DESC, Tag.MESSAGE_CONSTRAINTS); // invalid tag

        // invalid phone followed by valid email
        //assertParseFailure(parser,
        //        "1" + CommandTestUtil.INVALID_PHONE_DESC + CommandTestUtil.EMAIL_DESC_AMY,
        //        Phone.MESSAGE_CONSTRAINTS);

        // valid phone followed by invalid phone. The test case for invalid phone followed by valid phone
        // is tested at {@code parse_invalidValueFollowedByValidValue_success()}
        //assertParseFailure(parser,
        //        "1" + CommandTestUtil.PHONE_DESC_BOB + CommandTestUtil.INVALID_PHONE_DESC,
        //        Phone.MESSAGE_CONSTRAINTS);

        // while parsing {@code PREFIX_TAG} alone will reset the tags of the {@code Module} being edited,
        // parsing it together with a valid tag results in error
        //assertParseFailure(parser,
        //        "1" + CommandTestUtil.TAG_DESC_FRIEND + CommandTestUtil.TAG_DESC_HUSBAND + TAG_EMPTY,
        //        Tag.MESSAGE_CONSTRAINTS);
        //assertParseFailure(parser,
        //        "1" + CommandTestUtil.TAG_DESC_FRIEND + TAG_EMPTY + CommandTestUtil.TAG_DESC_HUSBAND,
        //        Tag.MESSAGE_CONSTRAINTS);
        //assertParseFailure(parser,
        //        "1" + TAG_EMPTY + CommandTestUtil.TAG_DESC_FRIEND + CommandTestUtil.TAG_DESC_HUSBAND,
        //        Tag.MESSAGE_CONSTRAINTS);

        // multiple invalid values, but only the first invalid value is captured
        //assertParseFailure(parser,
        //        "1" + CommandTestUtil.INVALID_NAME_DESC + CommandTestUtil.INVALID_EMAIL_DESC
        //                + CommandTestUtil.VALID_PHONE_AMY, Name.MESSAGE_CONSTRAINTS);
    }

    @Test
    public void parse_allFieldsSpecified_success() {
        //Index targetIndex = TypicalIndexes.INDEX_SECOND_PERSON;
        //String userInput = targetIndex.getOneBased() + CommandTestUtil.PHONE_DESC_BOB + CommandTestUtil.TAG_DESC_HUSBAND
        //        + CommandTestUtil.EMAIL_DESC_AMY + CommandTestUtil.NAME_DESC_AMY + CommandTestUtil.TAG_DESC_FRIEND;

        //EditModuleDescriptor descriptor = new EditModuleDescriptorBuilder().withName(CommandTestUtil.VALID_NAME_AMY)
        //        .withPhone(CommandTestUtil.VALID_PHONE_BOB).withEmail(CommandTestUtil.VALID_EMAIL_AMY)
        //        .withTags(CommandTestUtil.VALID_TAG_HUSBAND, CommandTestUtil.VALID_TAG_FRIEND).build();
        //ModuleEditCommand expectedCommand = new ModuleEditCommand(targetIndex, descriptor);

        //assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_someFieldsSpecified_success() {
        //Index targetIndex = TypicalIndexes.INDEX_FIRST_PERSON;
        //String userInput = targetIndex.getOneBased() + CommandTestUtil.PHONE_DESC_BOB + CommandTestUtil.EMAIL_DESC_AMY;

        //EditModuleDescriptor descriptor = new EditModuleDescriptorBuilder().withPhone(CommandTestUtil.VALID_PHONE_BOB)
        //        .withEmail(CommandTestUtil.VALID_EMAIL_AMY).build();
        //ModuleEditCommand expectedCommand = new ModuleEditCommand(targetIndex, descriptor);

        //assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_oneFieldSpecified_success() {
        // name
        //Index targetIndex = TypicalIndexes.INDEX_THIRD_PERSON;
        //String userInput = targetIndex.getOneBased() + CommandTestUtil.NAME_DESC_AMY;
        //ModuleEditCommand.EditModuleDescriptor descriptor = new EditModuleDescriptorBuilder()
        //        .withName(CommandTestUtil.VALID_NAME_AMY)
        //        .build();
        //ModuleEditCommand expectedCommand = new ModuleEditCommand(targetIndex, descriptor);
        //assertParseSuccess(parser, userInput, expectedCommand);

        // phone
        //userInput = targetIndex.getOneBased() + CommandTestUtil.PHONE_DESC_AMY;
        //descriptor = new EditModuleDescriptorBuilder().withPhone(CommandTestUtil.VALID_PHONE_AMY).build();
        //expectedCommand = new ModuleEditCommand(targetIndex, descriptor);
        //assertParseSuccess(parser, userInput, expectedCommand);

        // email
        //userInput = targetIndex.getOneBased() + CommandTestUtil.EMAIL_DESC_AMY;
        //descriptor = new EditModuleDescriptorBuilder().withEmail(CommandTestUtil.VALID_EMAIL_AMY).build();
        //expectedCommand = new ModuleEditCommand(targetIndex, descriptor);
        //assertParseSuccess(parser, userInput, expectedCommand);

        // tags
        //userInput = targetIndex.getOneBased() + CommandTestUtil.TAG_DESC_FRIEND;
        //descriptor = new EditModuleDescriptorBuilder().withTags(CommandTestUtil.VALID_TAG_FRIEND).build();
        //expectedCommand = new ModuleEditCommand(targetIndex, descriptor);
        //assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_multipleRepeatedFields_acceptsLast() {
        //Index targetIndex = TypicalIndexes.INDEX_FIRST_PERSON;
        //String userInput = targetIndex.getOneBased() + CommandTestUtil.PHONE_DESC_AMY + CommandTestUtil.EMAIL_DESC_AMY
        //        + CommandTestUtil.TAG_DESC_FRIEND + CommandTestUtil.PHONE_DESC_AMY + CommandTestUtil.EMAIL_DESC_AMY
        //        + CommandTestUtil.TAG_DESC_FRIEND + CommandTestUtil.PHONE_DESC_BOB + CommandTestUtil.EMAIL_DESC_BOB
        //        + CommandTestUtil.TAG_DESC_HUSBAND;

        //EditModuleDescriptor descriptor = new EditModuleDescriptorBuilder()
        //        .withPhone(CommandTestUtil.VALID_PHONE_BOB)
        //        .withEmail(CommandTestUtil.VALID_EMAIL_BOB)
        //        .withTags(CommandTestUtil.VALID_TAG_FRIEND, CommandTestUtil.VALID_TAG_HUSBAND)
        //        .build();
        //ModuleEditCommand expectedCommand = new ModuleEditCommand(targetIndex, descriptor);

        //assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_invalidValueFollowedByValidValue_success() {
        // no other valid values specified
        //Index targetIndex = TypicalIndexes.INDEX_FIRST_PERSON;
        //String userInput = targetIndex.getOneBased() + CommandTestUtil.INVALID_PHONE_DESC
        //        + CommandTestUtil.PHONE_DESC_BOB;
        //EditModuleDescriptor descriptor = new EditModuleDescriptorBuilder()
        //        .withPhone(CommandTestUtil.VALID_PHONE_BOB)
        //        .build();
        //ModuleEditCommand expectedCommand = new ModuleEditCommand(targetIndex, descriptor);
        //assertParseSuccess(parser, userInput, expectedCommand);

        // other valid values specified
        //userInput = targetIndex.getOneBased() + CommandTestUtil.EMAIL_DESC_BOB + CommandTestUtil.INVALID_PHONE_DESC
        //        + CommandTestUtil.PHONE_DESC_BOB;
        //descriptor = new EditModuleDescriptorBuilder()
        //        .withPhone(CommandTestUtil.VALID_PHONE_BOB)
        //        .withEmail(CommandTestUtil.VALID_EMAIL_BOB)
        //        .build();
        //expectedCommand = new ModuleEditCommand(targetIndex, descriptor);
        //assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_resetTags_success() {
        //Index targetIndex = TypicalIndexes.INDEX_THIRD_PERSON;
        //String userInput = targetIndex.getOneBased() + TAG_EMPTY;

        //ModuleEditCommand.EditModuleDescriptor descriptor = new EditModuleDescriptorBuilder().withTags().build();
        //ModuleEditCommand expectedCommand = new ModuleEditCommand(targetIndex, descriptor);

        //assertParseSuccess(parser, userInput, expectedCommand);
    }
}
